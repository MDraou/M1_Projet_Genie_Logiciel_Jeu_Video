package graphic;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.Serial;
import java.text.MessageFormat;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GraphicEntity extends JPanel {
  @Serial
  private static final long serialVersionUID = 4242L;
  private transient BufferedImage image;
  private Point2D coordinates;

  private final Logger logger = LogManager.getLogger(this.getClass());


  public GraphicEntity(String path, Point2D coordinates) {
    logger.debug("Construct a MyJavaPanel");
    createImage(path);
    this.coordinates = coordinates;
  }

  public GraphicEntity(String path, int coordX, int coordY) {
    logger.debug("Construct a MyJavaPanel");
    createImage(path);
    this.coordinates = new Point2D.Double(coordX, coordY);
  }

  private void createImage(String path) {
    if (logger.isDebugEnabled()) logger.debug(MessageFormat.format("Loading image at path {0}", path));
    try { image = ImageIO.read(Objects.requireNonNull(getClass().getResource(path))); }
    catch (Exception ex) { logger.error(MessageFormat.format("Error: Cannot load image at path: {0}", path)); }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, (int) coordinates.getX(), (int) coordinates.getY(), null);
  }

  public void setOpacity(float opacity) {
    BufferedImage resizedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = resizedImage.createGraphics();
    graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
    graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    graphics.dispose();

  }

  public void setCoordinates(Point2D newCoordinates) {
    coordinates = newCoordinates;
  }

  public void setCoordinates(int newCoordX, int newCoordY) {
    coordinates = new Point2D.Double(newCoordX, newCoordY);
  }

  public void rotate(double angle) {
    double radian = Math.toRadians(angle), sin = Math.abs(Math.sin(radian)), cos = Math.abs(Math.cos(radian));

    int newWidth = (int) Math.floor((double) image.getWidth() * cos + (double) image.getHeight() * sin);
    int newHeight = (int) Math.floor((double) image.getHeight() * cos + (double) image.getWidth() * sin);

    BufferedImage rotatedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

    Graphics2D graphics = rotatedImage.createGraphics();

    graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

    graphics.translate((newWidth - image.getWidth()) / 2, (newHeight - image.getHeight()) / 2);
    // rotation around the center point
    graphics.rotate(radian, (double) (image.getWidth() / 2), (double) (image.getHeight() / 2));
    graphics.drawImage(image, 0, 0, null);
    graphics.dispose();
  }
}

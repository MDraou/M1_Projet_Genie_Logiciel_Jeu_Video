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

  public void setCoordinates(Point2D newCoordinates) {
    coordinates = newCoordinates;
  }

  public void setCoordinates(int newCoordX, int newCoordY) {
    coordinates = new Point2D.Double(newCoordX, newCoordY);
  }

  public void rotate(double angle) {
  }
}

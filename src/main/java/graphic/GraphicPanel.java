package graphic;

import CoreKernel.Entity;

import java.awt.*;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

public class GraphicPanel extends JPanel {
  private final Point2D coordinates = new Point2D.Double();
  private GraphicEntity graphicEntity;

  public GraphicPanel(Point2D coordinates) {
    this.coordinates.setLocation(coordinates);
    this.setOpaque(false);
  }

  public GraphicPanel(int x, int y) {
    this.coordinates.setLocation(x, y);
    this.setOpaque(false);
  }

  @Override
  protected void paintComponent(Graphics graphic) {
    super.paintComponent(graphic);
    graphic.drawImage(graphicEntity.getSprite(), (int) coordinates.getX(), (int) coordinates.getY(), (int) graphicEntity.getWidth(), (int) graphicEntity.getHeight(),null);
  }

  public void setCoordinates(Point2D newCoordinates) {
    coordinates.setLocation(newCoordinates);
    repaint();
  }

  public void setCoordinates(int x, int y) {
    coordinates.setLocation(x, y);
    repaint();
  }

  public Point2D getCoordinates() {
    return coordinates;
  }

  public void setGraphicEntity(GraphicEntity entity) {
    this.graphicEntity = entity;
    repaint();
  }

  public GraphicEntity getGraphicEntity() {
    return graphicEntity;
  }
}

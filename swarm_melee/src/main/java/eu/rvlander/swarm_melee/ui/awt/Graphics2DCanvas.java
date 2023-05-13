package eu.rvlander.swarm_melee.ui.awt;

import eu.rvlander.swarm_melee.ui.core.Canvas;
import eu.rvlander.swarm_melee.ui.core.Color;
import eu.rvlander.swarm_melee.utils.CoordinateConvertor;
import eu.rvlander.swarm_melee.utils.Point;
import java.awt.BasicStroke;
import java.awt.Graphics2D;


public class Graphics2DCanvas implements Canvas {
  private Graphics2D g;
  private CoordinateConvertor convertor;

  public Graphics2DCanvas(Graphics2D g, CoordinateConvertor convertor) {
    this.g = g;
    this.convertor = convertor;
  }

  private static java.awt.Color colorToAwtColor(Color c) {
    return new java.awt.Color(c.getR(), c.getB(), c.getG());
  }

  @Override
  public void drawFilledSquare(Point center, int size, Color color) {
    Point convertedCenter = convertor.convertPoint(center);
    int convertedSize = convertor.convertDistance(size);
    g.setColor(colorToAwtColor(color));
    g.fillRect(convertedCenter.getX() - convertedSize / 2,
        convertedCenter.getY() - convertedSize / 2, convertedSize, convertedSize);
  }

  @Override
  public void drawFilledCircle(Point center, int radius, Color color) {
    Point convertedCenter = convertor.convertPoint(center);
    int convertedRadius = convertor.convertDistance(radius);
    g.setColor(colorToAwtColor(color));
    g.fillOval(convertedCenter.getX() - convertedRadius / 2,
        convertedCenter.getY() - convertedRadius / 2, convertedRadius, convertedRadius);
  }

  @Override
  public void drawCircle(Point center, int radius, Color color) {
    Point convertedCenter = convertor.convertPoint(center);
    int convertedRadius = radius;
    g.setStroke(new BasicStroke(5));
    g.setColor(colorToAwtColor(color));
    g.drawOval(convertedCenter.getX() - convertedRadius / 2,
        convertedCenter.getY() - convertedRadius / 2, convertedRadius, convertedRadius);
  }



}

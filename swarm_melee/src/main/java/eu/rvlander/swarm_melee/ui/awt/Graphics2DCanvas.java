package eu.rvlander.swarm_melee.ui.awt;

import eu.rvlander.swarm_melee.ui.core.Canvas;
import eu.rvlander.swarm_melee.ui.core.Color;
import eu.rvlander.swarm_melee.utils.Point;
import java.awt.Graphics2D;


public class Graphics2DCanvas implements Canvas {
  private Graphics2D g;

  public Graphics2DCanvas(Graphics2D g) {
    this.g = g;
  }

  private static java.awt.Color colorToAwtColor(Color c) {
    return new java.awt.Color(c.getR(), c.getB(), c.getG());
  }

  @Override
  public void drawFilledSquare(Point center, int size, Color color) {
    g.setColor(colorToAwtColor(color));
    g.fillRect(center.getX() - size / 2, center.getY() - size / 2, size, size);
  }

  @Override
  public void drawFilledCircle(Point center, int radius, Color color) {
    g.setColor(colorToAwtColor(color));
    g.fillOval(center.getX() - radius / 2, center.getY() - radius / 2, radius, radius);
  }



}

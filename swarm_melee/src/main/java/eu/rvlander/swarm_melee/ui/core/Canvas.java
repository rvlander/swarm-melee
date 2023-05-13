package eu.rvlander.swarm_melee.ui.core;

import eu.rvlander.swarm_melee.utils.Point;

public interface Canvas {
  public void drawFilledSquare(Point center, int size, Color color);

  public void drawFilledCircle(Point center, int radius, Color color);

  public void drawCircle(Point center, int radius, Color color);
}

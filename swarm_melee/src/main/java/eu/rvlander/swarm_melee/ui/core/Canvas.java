package eu.rvlander.swarm_melee.ui.core;

public interface Canvas {
  public void drawFilledSquare(Point center, int size, Color color);

  public void drawFilledCircle(Point center, int radius, Color color);
}

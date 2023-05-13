package eu.rvlander.swarm_melee.utils;

public class CoordinateSpace {
  private Point origin;
  private int relativeWidth;
  private int relativeHeight;

  public CoordinateSpace(Point bottomLeft, Point upperRight) {
    origin = bottomLeft;
    relativeWidth = upperRight.getX() - bottomLeft.getX();
    relativeHeight = upperRight.getY() - bottomLeft.getY();
  }

  public Point getOrigin() {
    return origin;
  }

  public int getRelativeWidth() {
    return relativeWidth;
  }

  public int getRelativeHeight() {
    return relativeHeight;
  }

  public int getWidth() {
    return Math.abs(relativeWidth);
  }

  public int getHeight() {
    return Math.abs(relativeHeight);
  }
}

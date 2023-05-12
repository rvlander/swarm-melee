package eu.rvlander.swarm_melee.utils;

public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Point(Point p) {
    this(p.x, p.y);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean equals(Point p) {
    return x == p.getX() && y == p.getY();
  }

  public float distance(Point p) {
    return (int) Math.sqrt(
        Math.pow(Math.abs(p.getX() - (float) x), 2) + Math.pow(Math.abs(p.getY() - (float) y), 2));
  }

  public Point move(int x, int y) {
    return new Point(getX() + x, getY() + y);
  }
}

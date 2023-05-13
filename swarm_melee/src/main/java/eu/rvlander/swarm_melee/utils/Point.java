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

  public Point add(Point p) {
    return new Point(x + p.x, y + p.y);
  }

  public Point minus(Point p) {
    return new Point(x - p.x, y - p.y);
  }

  public Point scale(float s) {
    return scale(s, s);
  }

  public Point scale(float scalerX, float scalerY) {
    return new Point((int) (x * scalerX), (int) (y * scalerY));
  }
}

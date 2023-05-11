package eu.rvlander.swarm_melee.utils;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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

    public int distance(Point p) {
        return Math.max(Math.abs(p.getX() - x), Math.abs(p.getY() - y));
    }

    public Point move(int x, int y) {
        return new Point(getX() + x, getY() + y);
    }
}

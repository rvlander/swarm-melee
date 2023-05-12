package eu.rvlander.swarm_melee.ui.core;

public class Color {
  private float r;
  private float g;
  private float b;
  private float a;

  public static Color red() {
    return new Color(1, 0, 0);
  }

  public static Color green() {
    return new Color(0, 1, 0);
  }

  public static Color blue() {
    return new Color(0, 0, 1);
  }

  public Color(float r, float g, float b, float a) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.a = a;
  }

  public Color(float r, float g, float b) {
    this(r, g, b, 1);
  }

  public Color(Color c) {
    this(c.r, c.g, c.b, c.a);
  }

  public float getR() {
    return r;
  }

  public float getG() {
    return g;
  }

  public float getB() {
    return b;
  }

  public float getA() {
    return a;
  }

  public Color darken(float percentage) {
    return new Color(r * percentage, g * percentage, b * percentage, a);
  }

  public Color opacity(float opacity) {
    return new Color(r, g, b, opacity);
  }
}

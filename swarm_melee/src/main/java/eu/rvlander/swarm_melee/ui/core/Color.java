package eu.rvlander.swarm_melee.ui.core;

public class Color {
  private float r;
  private float g;
  private float b;
  private float a;

  public Color(float r, float g, float b, float a) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.a = a;
  }

  public Color(float r, float g, float b) {
    new Color(r, g, b, 1);
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
}

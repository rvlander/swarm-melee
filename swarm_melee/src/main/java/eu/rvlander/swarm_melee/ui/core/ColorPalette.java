package eu.rvlander.swarm_melee.ui.core;

import java.util.ArrayList;

public class ColorPalette {
  private ArrayList<Color> colors = new ArrayList<>();

  public ColorPalette(Color[] colors) {
    for (Color color : colors) {
      this.colors.add(new Color(color));
    }
  }

  public Color getColor(int index) {
    int shortIndex = index % colors.size();
    return new Color(colors.get(shortIndex));
  }
}

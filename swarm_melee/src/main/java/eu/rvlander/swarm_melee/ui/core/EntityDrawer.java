package eu.rvlander.swarm_melee.ui.core;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;

public abstract class EntityDrawer {
  protected DrawingDevice drawingDevice;

  protected EntityDrawer(DrawingDevice dd) {
    drawingDevice = dd;
  }

  public abstract void drawCursor(Cursor cursor, Color color);

  public abstract void drawFighter(Fighter fighters, Color color);
}

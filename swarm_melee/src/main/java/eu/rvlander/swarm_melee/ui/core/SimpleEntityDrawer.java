package eu.rvlander.swarm_melee.ui.core;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;

public class SimpleEntityDrawer extends EntityDrawer {
  public SimpleEntityDrawer(DrawingDevice dd) {
    super(dd);
  }

  @Override
  public void drawCursor(Cursor cursor, Color color) {
    drawingDevice.drawFilledCircle(cursor.getPosition(), 20, color);
  }

  @Override
  public void drawFighter(Fighter fighter, Color color) {
    drawingDevice.drawFilledSquare(fighter.getPosition(), 1,
        color.darken(fighter.getHealthProportion()));
  }
}

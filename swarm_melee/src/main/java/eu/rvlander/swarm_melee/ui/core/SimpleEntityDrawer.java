package eu.rvlander.swarm_melee.ui.core;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;

public class SimpleEntityDrawer extends EntityDrawer {
  @Override
  public void drawCursor(Cursor cursor, Color color) {
    canvas.drawFilledCircle(cursor.getPosition(), 20, color);
  }

  @Override
  public void drawFighter(Fighter fighter, Color color) {
    canvas.drawFilledSquare(fighter.getPosition(), 2, color.darken(fighter.getHealthProportion()));
  }
}

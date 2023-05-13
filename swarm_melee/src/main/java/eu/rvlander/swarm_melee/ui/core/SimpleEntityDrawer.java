package eu.rvlander.swarm_melee.ui.core;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;

public class SimpleEntityDrawer extends EntityDrawer {
  @Override
  public void drawCursor(Cursor cursor, Color color) {
    canvas.drawCircle(cursor.getPosition(), 20, color.darken(0.8f));
  }

  @Override
  public void drawFighter(Fighter fighter, Color color) {
    canvas.drawFilledSquare(fighter.getPosition(), 3, color.darken(fighter.getHealthProportion()));
  }
}

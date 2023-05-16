package eu.rvlander.swarm_melee.ui.core;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.utils.Point;

public class SimpleEntityDrawer extends EntityDrawer {
  @Override
  public void drawBackGround(int w, int h, Color color) {
    canvas.drawFilledRectangle(new Point(0,0), new Point(w,h), color);
  }

  @Override
  public void drawCursor(Cursor cursor, Color color) {
    canvas.drawCircle(cursor.getPosition(), 20, color.darken(0.8f));
  }

  @Override
  public void drawFighter(Fighter fighter, Color color) {
    canvas.drawFilledSquare(fighter.getPosition(), 3, color.darken(fighter.getHealthProportion()));
  }
}

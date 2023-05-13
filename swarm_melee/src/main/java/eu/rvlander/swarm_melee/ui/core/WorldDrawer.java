package eu.rvlander.swarm_melee.ui.core;

import java.util.List;
import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.World;

public class WorldDrawer {

  private EntityDrawer entityDrawer;
  private World world;
  private ColorPalette colorPalette;

  public WorldDrawer(World world) {
    this.entityDrawer = new SimpleEntityDrawer();
    this.world = world;
    this.colorPalette = new ColorPalette(new Color[] {Color.red(), Color.green(), Color.blue()});
  }


  public void setCanvas(Canvas canvas) {
    entityDrawer.setCanvas(canvas);
  }

  public void draw() {
    drawCursors();
    drawFighters();
  }

  public void drawCursors() {
    List<Cursor> cursors = world.getCursors();
    for (Cursor cursor : cursors) {
      Color color = colorPalette.getColor(cursor.getTeam().getId());
      entityDrawer.drawCursor(cursor, color);
    }
  }

  public void drawFighters() {
    List<Fighter> fighters = world.getFighters();
    for (Fighter fighter : fighters) {
      entityDrawer.drawFighter(fighter, colorPalette.getColor(fighter.getTeam().getId()));
    }
  }

  public int getWidth() {
    return this.world.getMap().getWidth();
  }

  public int getHeight() {
    return this.world.getMap().getHeight();
  }
}

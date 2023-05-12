package eu.rvlander.swarm_melee.ui.core;

import java.util.List;
import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.World;

public class WorldDrawer {

  private EntityDrawer entityDrawer;
  private DrawingDevice drawingDevice;
  private World world;
  private Canvas canvas;
  private ColorPalette colorPalette;

  public WorldDrawer(DrawingDevice drawingDevice) {
    this.drawingDevice = drawingDevice;
    this.entityDrawer = new SimpleEntityDrawer();
    this.world = world;
    this.colorPalette = new ColorPalette(new Color[] {Color.red(), Color.green(), Color.blue()});
  }

  public void initialize() {
    drawingDevice.initialize(world.getMap().getWidth(), world.getMap().getHeight());
  }

  public void setCavas(Canvas canvas) {
    this.canvas = canvas;
    entityDrawer.setCanvas(canvas);
  }

  public void draw() {
    drawCursors();
    drawFighters();
  }

  public void drawCursors() {
    List<Cursor> cursors = world.getCursors();
    for (Cursor cursor : cursors) {
      entityDrawer.drawCursor(cursor, colorPalette.getColor(cursor.getTeam().getId()));
    }
  }

  public void drawFighters() {
    List<Fighter> fighters = world.getFighters();
    for (Fighter fighter : fighters) {
      entityDrawer.drawFighter(fighter, colorPalette.getColor(fighter.getTeam().getId()));
    }
  }
}

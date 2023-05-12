package eu.rvlander.swarm_melee.ui.core;

import eu.rvlander.swarm_melee.core.model.World;

public class WorldDrawer {

  private EntityDrawer entityDrawer;
  private DrawingDevice drawingDevice;
  private World world;

  public WorldDrawer(DrawingDevice drawingDevice) {
    this.drawingDevice = drawingDevice;
    this.entityDrawer = new SimpleEntityDrawer(drawingDevice);
    this.world = world;
  }

  public void initialize() {
    drawingDevice.initialize(world.getMap().getWidth(), world.getMap().getHeight());
  }

  public void draw() {

  }

  public void drawCursors() {

  }
}

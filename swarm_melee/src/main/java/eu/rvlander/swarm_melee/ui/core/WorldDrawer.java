package eu.rvlander.swarm_melee.ui.core;

import eu.rvlander.swarm_melee.core.model.World;

public class WorldDrawer {

  private EntityDrawer entityDrawer;
  private DrawingDevice drawingDevice;
  private World world;

  public WorldDrawer(EntityDrawer entityDrawer, DrawingDevice drawingDevice) {
    this.entityDrawer = entityDrawer;
    this.drawingDevice = drawingDevice;
    this.world = world;
  }

  private void initialize() {
    drawingDevice.initialize(world.getMap().getWidth(), world.getMap().getHeight());
  }

  public void draw();
}

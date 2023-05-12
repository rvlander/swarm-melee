package eu.rvlander.swarm_melee.app;


import eu.rvlander.swarm_melee.core.engine.SimpleSimulationFactory;
import eu.rvlander.swarm_melee.core.engine.Simulation;
import eu.rvlander.swarm_melee.core.engine.WorldConfiguration;
import eu.rvlander.swarm_melee.ui.awt.AwtDrawingDevice;
import eu.rvlander.swarm_melee.ui.core.WorldDrawer;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AwtApp {
  public static void main(String args[]) {


    WorldConfiguration configuration = new WorldConfiguration(1, 200, 400, 400);

    final Simulation simulation = new Simulation(new SimpleSimulationFactory(), configuration);

    final WorldDrawer worldDrawer = new WorldDrawer(simulation.getWorld());
    AwtDrawingDevice drawingDevice = new AwtDrawingDevice(worldDrawer);
    drawingDevice.initialize(configuration.getWidth(), configuration.getHeight());



    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
    executor.scheduleAtFixedRate(simulation::runStep, 0, 40, TimeUnit.MILLISECONDS);
    executor.scheduleAtFixedRate(drawingDevice::repaint, 0, 40, TimeUnit.MILLISECONDS);
  }
}

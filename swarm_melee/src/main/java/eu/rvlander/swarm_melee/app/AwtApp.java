package eu.rvlander.swarm_melee.app;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import eu.rvlander.swarm_melee.core.engine.SimpleSimulationFactory;
import eu.rvlander.swarm_melee.core.engine.Simulation;
import eu.rvlander.swarm_melee.core.engine.WorldConfiguration;
import eu.rvlander.swarm_melee.ui.awt.AwtDrawingDevice;
import eu.rvlander.swarm_melee.ui.core.WorldDrawer;

public class AwtApp {
  public static void main(String args[]) {
    AwtDrawingDevice drawingDevice = new AwtDrawingDevice();

    WorldConfiguration configuration = new WorldConfiguration(1, 20, 400, 400);

    final Simulation simulation = new Simulation(new SimpleSimulationFactory(), configuration);



    final WorldDrawer worldDrawer = new WorldDrawer(drawingDevice);
    worldDrawer.initialize();


    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
    executor.scheduleAtFixedRate(simulation::runStep, 0, 40, TimeUnit.MILLISECONDS);
    executor.scheduleAtFixedRate(worldDrawer::draw, 0, 40, TimeUnit.MILLISECONDS);
  }
}

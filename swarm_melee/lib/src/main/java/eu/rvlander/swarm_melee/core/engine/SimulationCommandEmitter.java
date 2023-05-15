package eu.rvlander.swarm_melee.core.engine;

public interface SimulationCommandEmitter {
  public void setSimulationCommandReceiver(SimulationCommandReceiver receiver);

  public void poll();
}

package eu.rvlander.swarm_melee.core.engine;

import java.util.List;

import eu.rvlander.swarm_melee.core.model.Cursor;

public interface SimulationCommandEmitter {
  public void setSimulationCommandReceiver(SimulationCommandReceiver receiver);

  public void setCursorList(List<Cursor> cursorList);

  public void poll();
}

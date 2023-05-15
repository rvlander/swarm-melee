package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.core.model.Team;

public interface SimulationCommandReceiver {
  public void teamInputLeft(Team t);

  public void teamInputUp(Team t);

  public void teamInputRight(Team t);

  public void teamInputDown(Team t);
}

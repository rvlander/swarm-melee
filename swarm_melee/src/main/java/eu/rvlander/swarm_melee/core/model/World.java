package eu.rvlander.swarm_melee.core.model;

import java.util.List;

import eu.rvlander.swarm_melee.utils.Point;

public interface World {
  public Map getMap();

  public List<Cursor> getCursors();

  public List<Fighter> getFighters();

  public Cursor getCursor(Team team);

  public PositionLookup lookupPosition(Point position);
}

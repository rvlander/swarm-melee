package eu.rvlander.swarm_melee.core.model;

import java.util.List;

public interface World {
    public Map getMap();
    public List<Cursor> getCursors();
    public List<Fighter> getFighters();
}

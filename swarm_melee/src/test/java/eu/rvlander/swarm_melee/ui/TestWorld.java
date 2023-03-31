package eu.rvlander.swarm_melee.ui;

import java.util.ArrayList;
import java.util.List;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.PositionLookup;
import eu.rvlander.swarm_melee.core.model.Team;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.utils.Point;

public class TestWorld implements World {

    private final Cursor cursorForTest = new CursorForTest(new Point(10,10));

    @Override
    public Map getMap() {
        return new MapForTest();
    }

    @Override
    public List<Cursor> getCursors() {
        final List<Cursor> cursorsList = new ArrayList<>();
        cursorsList.add(cursorForTest);
        return cursorsList;
    }

    @Override
    public List<Fighter> getFighters() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFighters'");
    }

    @Override
    public Cursor getCursor(Team team) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCursor'");
    }

    @Override
    public PositionLookup lookupPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lookupPosition'");
    }
    
}

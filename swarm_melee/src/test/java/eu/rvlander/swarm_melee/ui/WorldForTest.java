package eu.rvlander.swarm_melee.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.Point;
import eu.rvlander.swarm_melee.core.model.PositionLookup;
import eu.rvlander.swarm_melee.core.model.Team;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.ui.awt.AwtDrawableCursor;
import eu.rvlander.swarm_melee.ui.awt.AwtDrawableFighter;
import eu.rvlander.swarm_melee.ui.awt.AwtMap;
import eu.rvlander.swarm_melee.ui.awt.AwtTeam;

public class WorldForTest implements World {

    private final Cursor cursor1ForTest = new AwtDrawableCursor(new Point(10,10), Color.RED);
    private final Cursor cursor2ForTest = new AwtDrawableCursor(new Point(100,100), Color.BLUE);
    private final Map mapForTest = new AwtMap(800, 600);
    private final List<Fighter> fighters = new ArrayList<>();

    public WorldForTest() {
        for (int i = 1; i <= 10; i++) {
            this.fighters.add(new AwtDrawableFighter(new Point(10+i, 10+i), Color.RED));
            this.fighters.add(new AwtDrawableFighter(new Point(100+i, 100+i), Color.BLUE));
        }
    }

    @Override
    public Map getMap() {
        return this.mapForTest;
    }

    @Override
    public List<Cursor> getCursors() {
        final List<Cursor> cursorsList = new ArrayList<>();
        cursorsList.add(cursor1ForTest);
        cursorsList.add(cursor2ForTest);
        return cursorsList;
    }

    @Override
    public List<Fighter> getFighters() {
        return this.fighters;
    }

    @Override
    public Cursor getCursor(Team team) {
        for (final Cursor c : this.getCursors()) {
            final AwtDrawableCursor awtc = (AwtDrawableCursor)c;
            final AwtTeam awtCursorTeam = (AwtTeam)awtc.getTeam();
            if (((AwtTeam)team).getColor().equals(awtCursorTeam.getColor())) {
                return c;
            }
        }
        return null;
    }

    @Override
    public PositionLookup lookupPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lookupPosition'");
    }
    
}

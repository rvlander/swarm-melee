package eu.rvlander.swarm_melee.ui.awt;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.PositionLookup;
import eu.rvlander.swarm_melee.core.model.Team;
import eu.rvlander.swarm_melee.core.model.World;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JComponent;

public class AwtWorld extends JComponent implements World {

    private final Map map;
    private final List<Fighter> fighters;
    private final List<Cursor> cursorsList;

    public void paintComponent(Graphics g) {
        final Graphics2D d2g = (Graphics2D) g ;

        for (final Cursor c : this.getCursors()) {
            ((AwtDrawableCursor)c).paintComponent(d2g);;
        }

        for (final Fighter f : this.getFighters()) {
            ((AwtDrawableFighter)f).paintComponent(d2g);;
        }
    }

    public AwtWorld(final List<Cursor> cursorsList, final List<Fighter> fighters, final Map map) {
        this.cursorsList = cursorsList;
        this.fighters = fighters;
        this.map = map;
    }

    @Override
    public Map getMap() {
        return this.map;
    }

    @Override
    public List<Cursor> getCursors() {
        return this.cursorsList;
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
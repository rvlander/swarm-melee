package eu.rvlander.swarm_melee.ui;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Movement;
import eu.rvlander.swarm_melee.core.model.Point;
import eu.rvlander.swarm_melee.core.model.Team;

public class CursorForTest implements Cursor {

    private int x;
    private int y;

    public CursorForTest(final Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    @Override
    public Point getPosition() {
        return new Point(this.x, this.y);
    }

    @Override
    public void movePosition(Movement mov) {
        this.x += mov.getDeltaX();
        this.y += mov.getDeltaY();
    }

    @Override
    public Team getTeam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeam'");
    }
    
}

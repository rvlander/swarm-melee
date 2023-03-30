package eu.rvlander.swarm_melee.ui.awt;

import eu.rvlander.swarm_melee.core.model.Movement;

public class AwtMovement implements Movement {

    private final int dx;
    private final int dy;

    public AwtMovement(final int dx, final int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public Movement createMovement(int x, int y) {
        return null;
    }

    @Override
    public int getDeltaX() {
       return this.dx;
    }

    @Override
    public int getDeltaY() {
        return this.dy;
    }
    
}

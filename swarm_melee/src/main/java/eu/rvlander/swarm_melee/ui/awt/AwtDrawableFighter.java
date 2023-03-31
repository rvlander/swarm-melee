package eu.rvlander.swarm_melee.ui.awt;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.Movement;
import eu.rvlander.swarm_melee.core.model.Point;
import eu.rvlander.swarm_melee.core.model.Team;

public class AwtDrawableFighter implements Fighter {

    private int x;
    private int y;
    private AwtTeam team;
    private int health;

    public AwtDrawableFighter(final Point p, final Color c) {
        this.x = p.getX();
        this.y = p.getY();
        this.team = new AwtTeam(c, c.toString());
        this.health = 100;
    }

    public void paintComponent(Graphics g) {
        final Graphics2D d2g = (Graphics2D) g ;
        d2g.setStroke(new BasicStroke(2));
        d2g.setColor(this.team.getColor());
        d2g.draw(new Rectangle(new java.awt.Point(this.getPosition().getX(), this.getPosition().getY())));
    }

    @Override
    public Point getPosition() {
        return new Point(this.x, this.y);
    }

    @Override
    public void move(Movement mov) {
        this.x += mov.getDeltaX();
        this.y += mov.getDeltaY();
    }

    @Override
    public void decreaseHealth() {
        if (this.health >= 0) {
            this.health -= 1;
        }
    }

    @Override
    public void increaseHealth() {
        if (this.health <= 100) {
            this.health += 1;
        }
    }

    @Override
    public Team getTeam() {
        return this.team;
    }

    @Override
    public void setTeam(Team t) {
        this.team = (AwtTeam)t;
    }
    
}

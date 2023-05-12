package eu.rvlander.swarm_melee.ui.awt;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Movement;
import eu.rvlander.swarm_melee.core.model.Team;
import eu.rvlander.swarm_melee.utils.Point;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class AwtDrawableCursor implements Cursor {

  private int x;
  private int y;
  private final AwtTeam team;

  public AwtDrawableCursor(final Point p, final Color c) {
    this.x = p.getX();
    this.y = p.getY();
    this.team = new AwtTeam(c, c.toString());
  }

  public void paintComponent(Graphics g) {
    final Graphics2D d2g = (Graphics2D) g;
    d2g.setStroke(new BasicStroke(10));
    d2g.setColor(this.team.getColor());
    d2g.draw(
        new Rectangle(new java.awt.Point(this.getPosition().getX(), this.getPosition().getY())));
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
    return this.team;
  }

}

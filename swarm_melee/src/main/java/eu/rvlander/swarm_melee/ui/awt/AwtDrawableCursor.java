package eu.rvlander.swarm_melee.ui.awt;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.ui.interfaces.DrawableCursorInterface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class AwtDrawableCursor extends JComponent implements DrawableCursorInterface {

    private final Cursor cursor;

    public AwtDrawableCursor(final Cursor c) {
        this.cursor = c;
    }

    public void paintComponent(Graphics g) {
        final Graphics2D d2g = (Graphics2D) g ;
        d2g.setStroke(new BasicStroke(10));
        d2g.setColor(Color.black);
        d2g.draw(new Rectangle(new java.awt.Point(this.cursor.getPosition().getX(), this.cursor.getPosition().getY())));
    }

}
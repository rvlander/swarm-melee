package eu.rvlander.swarm_melee.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.ui.awt.AwtDrawableCursor;
import eu.rvlander.swarm_melee.ui.awt.AwtMovement;

public class MainWindow extends JFrame {

    private final World w;
    public MainWindow(final World w) {
        super("Swarm Melee V1.0");
        this.w = w;
        setSize(this.w.getMap().getTopRight().getX(), this.w.getMap().getBottomLeft().getY());
        setLocationRelativeTo(null);
        final AwtDrawableCursor c1 = new AwtDrawableCursor(this.w.getCursors().get(0));
        add(c1);

        final KeyListener k = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // nothing to do
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //update cursor and repaint
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        w.getCursors().get(0).movePosition(new AwtMovement(0, -10));
                        break;
                    case KeyEvent.VK_DOWN:
                        w.getCursors().get(0).movePosition(new AwtMovement(0, 10));
                        break;
                    case KeyEvent.VK_LEFT:
                        w.getCursors().get(0).movePosition(new AwtMovement(-10, 0));
                        break;
                    case KeyEvent.VK_RIGHT:
                        w.getCursors().get(0).movePosition(new AwtMovement(10, 0));
                        break;
                    default:
                        break;
                }
                refresh();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                refresh();
            }
            
        };
        addKeyListener(k);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void refresh() {
        repaint();
    }
}

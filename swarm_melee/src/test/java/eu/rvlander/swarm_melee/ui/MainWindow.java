package eu.rvlander.swarm_melee.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.ui.awt.AwtMovement;
import eu.rvlander.swarm_melee.ui.awt.AwtWorld;

public class MainWindow extends JFrame {

    public MainWindow(final World w) {
        super("Swarm Melee V1.0");
        setSize(w.getMap().getTopRight().getX(), w.getMap().getBottomLeft().getY());
        setLocationRelativeTo(null);
        add(((AwtWorld)w));

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
                    case KeyEvent.VK_Z:
                        w.getCursors().get(1).movePosition(new AwtMovement(0, -10));
                        break;
                    case KeyEvent.VK_S:
                        w.getCursors().get(1).movePosition(new AwtMovement(0, 10));
                        break;
                    case KeyEvent.VK_Q:
                        w.getCursors().get(1).movePosition(new AwtMovement(-10, 0));
                        break;
                    case KeyEvent.VK_D:
                        w.getCursors().get(1).movePosition(new AwtMovement(10, 0));
                        break;    
                    default:
                        break;
                }
                updateFighters(w);
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

    private void updateFighters(final World w) {
        for(final Fighter f : w.getFighters()) {
            w.getCursor(f.getTeam()).getPosition();
        }
    }

    private void refresh() {
        repaint();
    }
}

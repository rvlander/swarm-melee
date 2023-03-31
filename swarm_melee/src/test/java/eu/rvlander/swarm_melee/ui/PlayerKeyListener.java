package eu.rvlander.swarm_melee.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.ui.awt.AwtMovement;

public class PlayerKeyListener implements KeyListener {

    private final World world;
    private static final int UP_P1 = KeyEvent.VK_UP;
    private static final int DOWN_P1 = KeyEvent.VK_DOWN;
    private static final int LEFT_P1 = KeyEvent.VK_LEFT;
    private static final int RIGHT_P1 = KeyEvent.VK_RIGHT;
    private static final int UP_P2 = KeyEvent.VK_Z;
    private static final int DOWN_P2 = KeyEvent.VK_S;
    private static final int LEFT_P2 = KeyEvent.VK_Q;
    private static final int RIGHT_P2 = KeyEvent.VK_D;
    private final Map<Integer, Boolean> keyPressed = new HashMap<>();

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public PlayerKeyListener(final World w) {
        this.world = w;
        
        final Runnable keyTimmer = new Runnable() {

            @Override
            public void run() {
                for (final Entry<Integer, Boolean> pressedKey : keyPressed.entrySet()) {
                    if (pressedKey.getValue()) {
                        final Cursor cursorP1 = world.getCursors().get(0);
                        final Cursor cursorP2 = world.getCursors().get(1);
                        switch (pressedKey.getKey()) {
                            // P1
                            case UP_P1:
                                if (cursorP1.getPosition().getY() + (-10) > 0) {
                                    cursorP1.movePosition(new AwtMovement(0, -10));
                                }
                                break;
                            case DOWN_P1:
                                if (cursorP1.getPosition().getY() + (10) < world.getMap().getBottomLeft().getY()) {
                                    cursorP1.movePosition(new AwtMovement(0, 10));
                                }
                                break;
                            case LEFT_P1:
                                if (cursorP1.getPosition().getX() + (-10) > 0) {
                                    cursorP1.movePosition(new AwtMovement(-10, 0));
                                }    
                                break;
                            case RIGHT_P1:
                                if (cursorP1.getPosition().getX() + (10) < world.getMap().getTopRight().getX()) {
                                    cursorP1.movePosition(new AwtMovement(10, 0));
                                }
                                break;    
                            // P2
                            case UP_P2:
                                if (cursorP2.getPosition().getY() + (-10) > 0) {
                                    cursorP2.movePosition(new AwtMovement(0, -10));
                                }
                                break;
                            case DOWN_P2:
                                if (cursorP2.getPosition().getY() + (10) < world.getMap().getBottomLeft().getY()) {
                                    cursorP2.movePosition(new AwtMovement(0, 10));
                                };
                                break;
                            case LEFT_P2:
                                if (cursorP2.getPosition().getX() + (-10) > 0) {
                                    cursorP2.movePosition(new AwtMovement(-10, 0));
                                }    
                                break;
                            case RIGHT_P2:
                                if (cursorP2.getPosition().getX() + (10) < world.getMap().getTopRight().getX()) {
                                    cursorP2.movePosition(new AwtMovement(10, 0));
                                }
                                break;    
                            default:
                                break;
                        }
                    }
                }
            }
            
        };
        scheduler.scheduleAtFixedRate(keyTimmer, 0, 120, TimeUnit.MILLISECONDS);
    }

    @Override
    public void keyTyped(KeyEvent e) {
       // nothing to do
    }

    private void setKeyMapValues(final KeyEvent e, final boolean v) {
        //update cursor
        switch (e.getKeyCode()) {
            // P1
            case UP_P1:
                keyPressed.put(UP_P1, v);
                e.consume();
                break;
            case DOWN_P1:
                keyPressed.put(DOWN_P1, v);
                e.consume();
                break;
            case LEFT_P1:   
                keyPressed.put(LEFT_P1, v);
                e.consume();
                break;
            case RIGHT_P1:
                keyPressed.put(RIGHT_P1, v);
                e.consume();
                break;    
            // P2
            case UP_P2:
                keyPressed.put(UP_P2, v);
                e.consume();
                break;
            case DOWN_P2:
                keyPressed.put(DOWN_P2, v);
                e.consume();
                break;
            case LEFT_P2:
   
                keyPressed.put(LEFT_P2, v);
                e.consume();
                break;
            case RIGHT_P2:
                keyPressed.put(RIGHT_P2, v);
                e.consume();
                break;    
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        setKeyMapValues(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        setKeyMapValues(e, false);
    }
    
}

package eu.rvlander.swarm_melee.ui.awt;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import eu.rvlander.swarm_melee.core.engine.SimulationCommandEmitter;
import eu.rvlander.swarm_melee.core.engine.SimulationCommandReceiver;
import eu.rvlander.swarm_melee.core.model.Team;


public class AwtKeyListener implements KeyListener, SimulationCommandEmitter {
  private static final int UP_P1 = KeyEvent.VK_UP;
  private static final int DOWN_P1 = KeyEvent.VK_DOWN;
  private static final int LEFT_P1 = KeyEvent.VK_LEFT;
  private static final int RIGHT_P1 = KeyEvent.VK_RIGHT;
  private static final int UP_P2 = KeyEvent.VK_Z;
  private static final int DOWN_P2 = KeyEvent.VK_S;
  private static final int LEFT_P2 = KeyEvent.VK_Q;
  private static final int RIGHT_P2 = KeyEvent.VK_D;

  private static final Team TEAM_ONE = new Team(0);
  private static final Team TEAM_TWO = new Team(1);

  private final Map<Integer, Boolean> keyPressed = new HashMap<>();
  private Optional<SimulationCommandReceiver> receiver = Optional.empty();

  public void poll() {
    if (receiver.isPresent()) {
      SimulationCommandReceiver someReceiver = receiver.orElseThrow();
      for (final Entry<Integer, Boolean> pressedKey : keyPressed.entrySet()) {
        if (pressedKey.getValue()) {
          switch (pressedKey.getKey()) {
            // P1
            case UP_P1:
              someReceiver.teamInputUp(TEAM_ONE);
              break;
            case DOWN_P1:
              someReceiver.teamInputDown(TEAM_ONE);
              break;
            case LEFT_P1:
              someReceiver.teamInputLeft(TEAM_ONE);
              break;
            case RIGHT_P1:
              someReceiver.teamInputRight(TEAM_ONE);
              break;
            // P2
            case UP_P2:
              someReceiver.teamInputUp(TEAM_TWO);
              break;
            case DOWN_P2:
              someReceiver.teamInputDown(TEAM_TWO);
              break;
            case LEFT_P2:
              someReceiver.teamInputLeft(TEAM_TWO);
              break;
            case RIGHT_P2:
              someReceiver.teamInputRight(TEAM_TWO);
              break;
            default:
              break;
          }
        }
      }
    }
  }



  @Override
  public void keyTyped(KeyEvent e) {
    // do nothing
  }

  private void setKeyMapValues(final KeyEvent e, final boolean v) {
    // update cursor
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

  @Override
  public void setSimulationCommandReceiver(SimulationCommandReceiver receiver) {
    this.receiver = Optional.of(receiver);
  }

}

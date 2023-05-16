package eu.rvlander.swarmmeleeandroid;

import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import eu.rvlander.swarm_melee.core.engine.SimulationCommandEmitter;
import eu.rvlander.swarm_melee.core.engine.SimulationCommandReceiver;
import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Team;
import eu.rvlander.swarm_melee.utils.CoordinateConvertor;
import eu.rvlander.swarm_melee.utils.Point;

public class SurfaceInputManager implements SimulationCommandEmitter {
    private enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    private Optional<SimulationCommandReceiver> receiver = Optional.empty();

    private final HashMap<Team, Set<Direction>> currentActions = new HashMap<>();
    private final HashMap<Integer, Cursor> cursorMap = new HashMap<>();
    private Optional<List<Cursor>> cursorList = Optional.empty();

    public boolean handleMotionEvent(MotionEvent e, CoordinateConvertor worldToScreen) {
        Log.v("Input", e.toString());
        Point eventCoords = worldToScreen.revertPoint(new Point((int) e.getX(), (int) e.getY()));
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                Optional<Cursor> cursor = getClosestCursor(eventCoords);
                if (cursor.isPresent()) {
                    cursorMap.put(0, cursor.get());
                    Set<Direction> actions = computeActions(cursor.get(), eventCoords);
                    currentActions.put(cursor.get().getTeam(), actions);
                }
            }
            break;
            case MotionEvent.ACTION_MOVE: {
                if (cursorMap.containsKey(0)) {
                    Cursor cursor = cursorMap.get(0);
                    Set<Direction> actions = computeActions(cursor, eventCoords);
                    currentActions.put(cursor.getTeam(), actions);
                }
            }
            break;
            case MotionEvent.ACTION_UP:
                cursorMap.clear();
                currentActions.clear();
                break;
            default:
                break;
        }

        return true;
    }

    private Optional<Cursor> getClosestCursor(Point actionCoords) {
        if (!cursorList.isPresent()) {
            return Optional.empty();
        }
        List<Cursor> cursorList = new ArrayList<Cursor>(this.cursorList.get());
        cursorList.sort((c1, c2) -> {
            float d1 = actionCoords.distance(c1.getPosition());
            float d2 = actionCoords.distance(c2.getPosition());

            return (int) (d1 - d2);
        });

        return Optional.of(cursorList.get(0));
    }

    private Set<Direction> computeActions(Cursor cursor, Point actionCoords) {
        Set<Direction> actions = new HashSet<>();
        Point cursorPosition = cursor.getPosition();
        if (actionCoords.getX() < cursorPosition.getX()) {
            actions.add(Direction.LEFT);
        }
        if (actionCoords.getX() > cursorPosition.getX()) {
            actions.add(Direction.RIGHT);
        }
        if (actionCoords.getY() < cursorPosition.getY()) {
            actions.add(Direction.DOWN);
        }
        if (actionCoords.getY() > cursorPosition.getY()) {
            actions.add(Direction.UP);
        }
        return actions;
    }

    @Override
    public void setSimulationCommandReceiver(SimulationCommandReceiver receiver) {
        this.receiver = Optional.of(receiver);
    }

    @Override
    public void setCursorList(List<Cursor> cursorList) {
        this.cursorList = Optional.of(cursorList);
    }

    @Override
    public void poll() {
        if (receiver.isPresent()) {
            for (Map.Entry<Team, Set<Direction>> entry : this.currentActions.entrySet()) {
                for (Direction direction : entry.getValue()) {
                    switch (direction) {
                        case UP:
                            receiver.get().teamInputUp(entry.getKey());
                            break;
                        case RIGHT:
                            receiver.get().teamInputRight(entry.getKey());
                            break;
                        case DOWN:
                            receiver.get().teamInputDown(entry.getKey());
                            break;
                        case LEFT:
                            receiver.get().teamInputLeft(entry.getKey());
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
}

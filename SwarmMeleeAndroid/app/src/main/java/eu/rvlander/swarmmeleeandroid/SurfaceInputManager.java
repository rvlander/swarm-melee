package eu.rvlander.swarmmeleeandroid;

import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import eu.rvlander.swarm_melee.core.engine.SimulationCommandEmitter;
import eu.rvlander.swarm_melee.core.engine.SimulationCommandReceiver;
import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Team;
import eu.rvlander.swarm_melee.utils.CoordinateConvertor;
import eu.rvlander.swarm_melee.utils.Pair;
import eu.rvlander.swarm_melee.utils.Point;

public class SurfaceInputManager implements SimulationCommandEmitter {
    private enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    private Optional<SimulationCommandReceiver> receiver = Optional.empty();

    private final Set<Pair<Team, Direction>> currentActions = new HashSet<>();
    private final HashMap<Integer, Cursor> cursorMap = new HashMap<>();
    private Optional<List<Cursor>> cursorList = Optional.empty();

    public boolean handleMotionEvent(MotionEvent e, CoordinateConvertor worldToScreen) {
        Log.v("Input", e.toString());
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Point eventCoords = worldToScreen.revertPoint(new Point((int)e.getX(), (int)e.getY()));
                Optional<Cursor> cursor = getClosestCursor(eventCoords);
                if(cursor.isPresent()) {
                    Set<Direction> actions = computeActions(cursor.get(), eventCoords);
                    currentActions.addAll(actions.stream().map(direction -> new Pair<>(cursor.get().getTeam(), direction)).collect(Collectors.toSet()));
                }
                break;
            case MotionEvent.ACTION_UP:
                currentActions.clear();
                break;
            default:
                break;
        }

        return true;
    }

    private Optional<Cursor> getClosestCursor(Point actionCoords) {
        if(!cursorList.isPresent()) {
            return Optional.empty();
        }
        List <Cursor> cursorList = new ArrayList<Cursor>(this.cursorList.get());
        cursorList.sort((c1, c2) -> {
            float d1 = actionCoords.distance(c1.getPosition());
            float d2 = actionCoords.distance(c2.getPosition());

            return (int)(d1 - d2);
        });

        return Optional.of(cursorList.get(0));
    }

    private Set<Direction> computeActions(Cursor cursor, Point actionCoords) {
        Set<Direction> actions = new HashSet<>();
        Point cursorPosition = cursor.getPosition();
        if(actionCoords.getX() < cursorPosition.getX()) {
            actions.add(Direction.LEFT);
        }
        if(actionCoords.getX() > cursorPosition.getX()) {
            actions.add(Direction.RIGHT);
        }
        if(actionCoords.getY() < cursorPosition.getY()) {
            actions.add(Direction.DOWN);
        }
        if(actionCoords.getY() > cursorPosition.getY()) {
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
        if(receiver.isPresent()) {
            for(Pair<Team, Direction> entry: this.currentActions) {
                switch (entry.getSecond()) {
                    case UP:
                        receiver.get().teamInputUp(entry.getFirst());
                        break;
                    case RIGHT:
                        receiver.get().teamInputRight(entry.getFirst());
                        break;
                    case DOWN:
                        receiver.get().teamInputDown(entry.getFirst());
                        break;
                    case LEFT:
                        receiver.get().teamInputLeft(entry.getFirst());
                        break;
                    default:
                        break;
                }
            }
        }
    }
}

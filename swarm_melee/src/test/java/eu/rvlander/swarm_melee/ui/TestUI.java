package eu.rvlander.swarm_melee.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.ui.awt.*;
import eu.rvlander.swarm_melee.utils.Point;

public class TestUI {
  public static void main(String[] args) throws Exception {
    System.out.println("Hello, World!");

    final AwtDrawableCursor cursor1ForTest = new AwtDrawableCursor(new Point(100, 100), Color.RED);
    final AwtDrawableCursor cursor2ForTest = new AwtDrawableCursor(new Point(500, 500), Color.BLUE);
    final List<Cursor> cursorsList = new ArrayList<>();
    cursorsList.add(cursor1ForTest);
    cursorsList.add(cursor2ForTest);

    final Map mapForTest = new AwtMap(1600, 900);

    final List<Fighter> fighters = new ArrayList<>();
    for (int i = 1; i <= 100000; i++) {
      fighters.add(new AwtDrawableFighter(new Point(100, 100), Color.RED));
      fighters.add(new AwtDrawableFighter(new Point(500, 500), Color.BLUE));
    }

    final World testWorld = new AwtWorld(cursorsList, fighters, mapForTest);
    new MainWindow(testWorld);
  }
}

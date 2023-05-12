package eu.rvlander.swarm_melee.ui;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.ui.awt.AwtWorld;
import eu.rvlander.swarm_melee.utils.Point;

public class MainWindow extends JFrame {

  private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  private final World world;

  public MainWindow(final World w) {
    super("Swarm Melee V1.0");
    this.world = w;
    setSize(this.world.getMap().getTopRight().getX(), this.world.getMap().getBottomLeft().getY());
    setLocationRelativeTo(null);
    add(((AwtWorld) this.world));

    addKeyListener(new PlayerKeyListener(this.world));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    final Runnable repaintTimmer = new Runnable() {

      @Override
      public void run() {
        refresh();
      }

    };
    scheduler.scheduleAtFixedRate(repaintTimmer, 0, 120, TimeUnit.MILLISECONDS);
  }

  private void updateFighters(final World w) {
    for (final Fighter f : this.world.getFighters()) {
      final Point teamCursorPosition = w.getCursor(f.getTeam()).getPosition();
      final int randX = getRandomInt(-300, 300);
      final int randY = getRandomInt(-300, 300);
      f.moveTo(new Point(teamCursorPosition.getX() + randX, teamCursorPosition.getY() + randY));
    }
  }

  private int getRandomInt(final int min, final int max) {
    return new Random().nextInt(max - (min) + 1) + (min);
  }

  private void refresh() {
    repaint();
    updateFighters(this.world);
  }
}

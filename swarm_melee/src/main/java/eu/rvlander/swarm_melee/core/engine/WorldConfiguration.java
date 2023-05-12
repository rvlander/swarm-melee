package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.World;

public class WorldConfiguration {
  private int nbCursors;
  private int nbFightersByCursors;
  private int width;
  private int height;
  private int cursorSpeed;

  public WorldConfiguration(int nbCursors, int nbFightersByCursors, int width, int height,
      int cursorSpeed) {
    this.nbCursors = nbCursors;
    this.nbFightersByCursors = nbFightersByCursors;
    this.width = width;
    this.height = height;
    this.cursorSpeed = cursorSpeed;
  }

  public int getNbCursors() {
    return nbCursors;
  }

  public int getNbFightersByCursors() {
    return nbFightersByCursors;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getCursorSpeed() {
    return cursorSpeed;
  }
}

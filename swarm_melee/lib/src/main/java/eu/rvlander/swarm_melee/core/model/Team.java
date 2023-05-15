package eu.rvlander.swarm_melee.core.model;

public class Team {
  private static int nextId = 0;
  private int id;

  public Team() {
    this.id = nextId++;
  }

  public Team(int id) {
    this.id = id;
  }

  boolean equals(Team t) {
    return this.id == t.id;
  }

  public int getId() {
    return id;
  }
}

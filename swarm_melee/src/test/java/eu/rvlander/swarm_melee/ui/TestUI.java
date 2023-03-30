package eu.rvlander.swarm_melee.ui;

import eu.rvlander.swarm_melee.core.model.World;

public class TestUI {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        final World testWorld = new TestWorld();
        new MainWindow(testWorld);
    }
}

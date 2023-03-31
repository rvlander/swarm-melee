package eu.rvlander.swarm_melee.ui.awt;

import java.awt.Color;

import eu.rvlander.swarm_melee.core.model.Team;

public class AwtTeam implements Team{
    
    private final Color color;
    
    public Color getColor() {
        return color;
    }

    private final String name;
    
    public String getName() {
        return name;
    }

    public AwtTeam(Color color, String name) {
        this.color = color;
        this.name = name;
    }

}

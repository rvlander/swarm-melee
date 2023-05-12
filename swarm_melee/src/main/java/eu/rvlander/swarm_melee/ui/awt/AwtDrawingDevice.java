package eu.rvlander.swarm_melee.ui.awt;

import javax.swing.JFrame;
import eu.rvlander.swarm_melee.ui.core.Color;
import eu.rvlander.swarm_melee.ui.core.DrawingDevice;
import eu.rvlander.swarm_melee.utils.Point;

public class AwtDrawingDevice extends JFrame implements DrawingDevice {

  @Override
  public void initialize(int width, int height) {
    setTitle("Swarm Melee V1.0");

    setSize(800, 800);
    setLocationRelativeTo(null);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }
}

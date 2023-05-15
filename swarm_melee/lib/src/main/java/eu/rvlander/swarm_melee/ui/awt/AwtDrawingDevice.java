package eu.rvlander.swarm_melee.ui.awt;


import eu.rvlander.swarm_melee.core.engine.SimulationCommandReceiver;
import eu.rvlander.swarm_melee.ui.core.Color;
import eu.rvlander.swarm_melee.ui.core.DrawingDevice;
import eu.rvlander.swarm_melee.ui.core.WorldDrawer;
import eu.rvlander.swarm_melee.utils.CoordinateConvertor;
import eu.rvlander.swarm_melee.utils.CoordinateSpace;
import eu.rvlander.swarm_melee.utils.Point;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AwtDrawingDevice extends JFrame implements DrawingDevice {
  private WorldDrawer drawer;

  public AwtDrawingDevice(WorldDrawer drawer) {
    this.drawer = drawer;
  }

  public class MainPanel extends JComponent {
    public void paintComponent(Graphics g) {
      Graphics2D g2D = (Graphics2D) g;
      CoordinateSpace sourceSpace =
          new CoordinateSpace(new Point(0, 0), new Point(drawer.getWidth(), drawer.getWidth()));

      Dimension dim = getSize();
      CoordinateSpace targetSpace = new CoordinateSpace(new Point(0, (int) dim.getHeight()),
          new Point((int) dim.getWidth(), 0));

      CoordinateConvertor convertor = new CoordinateConvertor(sourceSpace, targetSpace);

      drawer.setCanvas(new Graphics2DCanvas(g2D, convertor));
      drawer.draw();
      g.dispose();
    }
  }

  @Override
  public void initialize(int width, int height) {
    setTitle("Swarm Melee V1.0");

    setSize(800, 800);
    setLocationRelativeTo(null);
    add(new MainPanel());

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }
}

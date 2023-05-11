package eu.rvlander.swarm_melee.app;

import eu.rvlander.swarm_melee.ui.awt.AwtDrawingDevice;

public class AwtApp {

    public static void main(String args[]) {
        AwtDrawingDevice drawingDevice = new AwtDrawingDevice();

        drawingDevice.initialize(400, 400);
    }
}

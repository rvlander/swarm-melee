package eu.rvlander.swarmmeleeandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;

import eu.rvlander.swarm_melee.ui.core.DrawingDevice;
import eu.rvlander.swarm_melee.ui.core.WorldDrawer;
import eu.rvlander.swarm_melee.utils.CoordinateConvertor;
import eu.rvlander.swarm_melee.utils.CoordinateSpace;
import eu.rvlander.swarm_melee.utils.Point;

public class SurfaceViewDrawingDevice extends SurfaceView implements DrawingDevice {
    private WorldDrawer drawer;

    public SurfaceViewDrawingDevice(Context context, WorldDrawer drawer) {
        super(context);
        this.drawer = drawer;
        setWillNotDraw(false);
    }

    @Override
    public void initialize(int width, int height) {
        // do nothing
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        CoordinateSpace sourceSpace =
                new CoordinateSpace(new Point(0, 0), new Point(drawer.getWidth(), drawer.getWidth()));


        CoordinateSpace targetSpace = new CoordinateSpace(new Point(0, getHeight()),
                new Point(getWidth(), 0));

        CoordinateConvertor convertor = new CoordinateConvertor(sourceSpace, targetSpace);

        drawer.setCanvas(new SurfaceViewCanvas(canvas, convertor));
        drawer.draw();
    }
}

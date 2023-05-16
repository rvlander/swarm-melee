package eu.rvlander.swarmmeleeandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.Optional;

import eu.rvlander.swarm_melee.ui.core.DrawingDevice;
import eu.rvlander.swarm_melee.ui.core.WorldDrawer;
import eu.rvlander.swarm_melee.utils.CoordinateConvertor;
import eu.rvlander.swarm_melee.utils.CoordinateSpace;
import eu.rvlander.swarm_melee.utils.Point;

public class SurfaceViewDrawingDevice extends SurfaceView implements DrawingDevice {
    private WorldDrawer drawer;
    private SurfaceInputManager inputManager;
    private Optional<CoordinateConvertor> worldToScreen = Optional.empty();


    public SurfaceViewDrawingDevice(Context context, WorldDrawer drawer, SurfaceInputManager inputManager) {
        super(context);
        this.drawer = drawer;
        this.inputManager = inputManager;
        setWillNotDraw(false);
    }

    @Override
    public void initialize(int width, int height) {
        // do nothing
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        ensureWorldToScreen();

        drawer.setCanvas(new SurfaceViewCanvas(canvas, worldToScreen.get()));
        drawer.draw();
    }

    private void ensureWorldToScreen() {
        if(!worldToScreen.isPresent()) {
            worldToScreen = Optional.of(worldToScreen());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        ensureWorldToScreen();
        return inputManager.handleMotionEvent(e, worldToScreen.get());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if(oldw != w || oldh != h) {
            worldToScreen = Optional.of(worldToScreen());
        }
    }

    private CoordinateConvertor worldToScreen() {
        CoordinateSpace sourceSpace =
                new CoordinateSpace(new Point(0, 0), new Point(drawer.getWidth(), drawer.getWidth()));


        CoordinateSpace targetSpace = new CoordinateSpace(new Point(0, getHeight()),
                new Point(getWidth(), 0));

        return new CoordinateConvertor(sourceSpace, targetSpace);
    }
}

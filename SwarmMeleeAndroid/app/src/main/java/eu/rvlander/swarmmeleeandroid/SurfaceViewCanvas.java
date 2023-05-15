package eu.rvlander.swarmmeleeandroid;


import android.graphics.Paint;

import eu.rvlander.swarm_melee.ui.core.Canvas;
import eu.rvlander.swarm_melee.ui.core.Color;
import eu.rvlander.swarm_melee.utils.CoordinateConvertor;
import eu.rvlander.swarm_melee.utils.Point;


public class SurfaceViewCanvas implements Canvas {
    private android.graphics.Canvas canvas;
    private CoordinateConvertor convertor;

    public SurfaceViewCanvas(android.graphics.Canvas canvas, CoordinateConvertor convertor) {
        this.canvas = canvas;
        this.convertor = convertor;
    }

    private void setPaintColor(Paint p, Color color) {
        p.setARGB((int) (color.getA() * 255), (int) (color.getR() * 255),
                (int) (color.getG() * 255), (int) (color.getB() * 255));
    }

    @Override
    public void drawFilledSquare(Point center, int size, Color color) {
        Point convertedCenter = convertor.convertPoint(center);
        int convertedSize = convertor.convertDistance(size);
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        setPaintColor(p, color);
        canvas.drawRect(convertedCenter.getX() - convertedSize / 2,
                convertedCenter.getY() - convertedSize / 2,  convertedCenter.getX() + convertedSize / 2,
                convertedCenter.getY() + convertedSize / 2, p);
    }

    @Override
    public void drawFilledCircle(Point center, int radius, Color color) {
        Point convertedCenter = convertor.convertPoint(center);
        int convertedRadius = convertor.convertDistance(radius);
        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        setPaintColor(p, color);
        canvas.drawOval(convertedCenter.getX() - convertedRadius / 2,
                convertedCenter.getY() - convertedRadius / 2, convertedCenter.getX() + convertedRadius / 2,
                convertedCenter.getY() + convertedRadius / 2, p);
    }

    @Override
    public void drawCircle(Point center, int radius, Color color) {
        Point convertedCenter = convertor.convertPoint(center);
        int convertedRadius = radius;
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(3);
        setPaintColor(p, color);
        canvas.drawOval(convertedCenter.getX() - convertedRadius / 2,
                convertedCenter.getY() - convertedRadius / 2, convertedCenter.getX() + convertedRadius / 2,
                convertedCenter.getY() + convertedRadius / 2, p);
    }


}

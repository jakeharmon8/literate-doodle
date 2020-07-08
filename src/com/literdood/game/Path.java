package com.literdood.game;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Path {
    ArrayList<Point2D.Float> points = new ArrayList<>();

    public Path() {
        points.add(new Point2D.Float(0, 0));
        points.add(new Point2D.Float(100, 100));
        points.add(new Point2D.Float(200, 100));
        points.add(new Point2D.Float(250, 150));
        points.add(new Point2D.Float(250, 200));
        points.add(new Point2D.Float(250, 250));
        points.add(new Point2D.Float(200, 300));
        points.add(new Point2D.Float(100, 300));
        points.add(new Point2D.Float(50, 250));
        points.add(new Point2D.Float(150, 225));
        points.add(new Point2D.Float(250, 225));
        points.add(new Point2D.Float(350, 250));
        points.add(new Point2D.Float(400, 300));
        points.add(new Point2D.Float(400, 350));
        points.add(new Point2D.Float(350, 400));
        points.add(new Point2D.Float(512, 512));
    }

    public Point2D.Float getStart() {
        return points.get(0);
    }

    public Point2D.Float getEnd() {
        return points.get(points.size() - 1);
    }

    public PathInfo getNextPosition(float progress, float speed) {
         while(speed > 0) {
            if((int) progress >= points.size() - 1) {
                return new PathInfo(progress, getEnd(), true);
            }

            Point2D.Float prev = points.get((int) progress);
            Point2D.Float next = points.get((int) progress + 1);
            double dist = prev.distance(next);

            double progressScaled = (progress - (int) progress) * dist;
            double nextProgressScaled = progressScaled + speed;

            if(nextProgressScaled > dist) {
                progress = (int) progress + 1;
                speed = (float) (nextProgressScaled - dist);
                continue;
            }

            float nextProgress = (float)((int) progress + nextProgressScaled / dist);
            float scale = (float)(nextProgressScaled / dist);
            Point2D.Float nextPosition = new Point2D.Float((float)((next.x - prev.x) * scale + prev.x), (float)((next.y - prev.y) * scale + prev.y));
            return new PathInfo(nextProgress, nextPosition, false);
        }

        return null;
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        for(int i = 0; i < points.size()-1; i++) {
            Point2D.Float p1 = points.get(i);
            Point2D.Float p2 = points.get(i + 1);
            g.drawLine((int) p1.x, (int) p1.y, (int) p2.x, (int) p2.y);
        }

        g.setColor(Color.green);
        int size = 16;
        for(Point2D.Float p : points) {
            g.drawOval((int) (p.x - size/2), (int) (p.y - size/2), size, size);
        }
    }

    public class PathInfo {
        public float nextProgress;
        public Point2D.Float nextPosition;
        boolean finished;

        public PathInfo(float nextProgress, Point2D.Float nextPosition, boolean finished) {
            this.nextProgress = nextProgress;
            this.nextPosition = nextPosition;
            this.finished = finished;
        }
    }
}

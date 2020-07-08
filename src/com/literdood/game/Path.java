package com.literdood.game;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Path {
    ArrayList<Point2D.Float> points = new ArrayList<>();

    public Path() {
        points.add(new Point2D.Float(0f, 0f));
        points.add(new Point2D.Float(50f, 50f));
        points.add(new Point2D.Float(100f, 50f));
        points.add(new Point2D.Float(512f, 512f));
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
                speed -= nextProgressScaled - dist;
            }

            float nextProgress = (float)((int) progress + nextProgressScaled / dist);
            float scale = (float)(nextProgressScaled / dist);
            Point2D.Float nextPosition = new Point2D.Float((float)((next.x - prev.x) * scale + prev.x), (float)((next.y - prev.y) * scale + prev.y));
            return new PathInfo(nextProgress, nextPosition, false);
        }

        return null;
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

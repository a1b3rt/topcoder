package com.albert.srm614.div2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Albert on 5/19/2014.
 */
public class MinimumSquareEasy {

    public static void main(String[] args) {
        new MinimumSquareEasy().minArea(new int[] {0, 1, 2}, new int[] {0, 1, 5});
    }

    public long minArea(int[] x, int[] y) {
        List<Point> points = new ArrayList<>(x.length);
        for (int i = 0; i < x.length; i++) {
            points.add(new Point(x[i], y[i]));
        }
        long area = Long.MAX_VALUE;
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                List<Point> uttermost = getUttermost(points, i, j);
                Point topLeft = new Point(uttermost.get(0).x - 1, uttermost.get(1).y + 1);
                Point bottomRight = new Point(uttermost.get(2).x + 1, uttermost.get(3).y - 1);
                long max = Math.max((bottomRight.x - topLeft.x), (topLeft.y - bottomRight.y));
                area = Math.min(area, max * max);
            }
        }
        return area;
    }

    private List<Point> getUttermost(List<Point> points, int exclude1, int exclude2) {
        List<Point> uttermost = new ArrayList<>(4);
        Point topmost = null;
        Point leftmost = null;
        Point rightmost = null;
        Point bottommost = null;
        for (int i = 0; i < points.size(); i++) {
            if (i == exclude1 || i == exclude2) {
                continue;
            }
            if (leftmost == null) {
                leftmost = points.get(i);
            }
            if (rightmost == null) {
                rightmost = points.get(i);
            }
            if (bottommost == null) {
                bottommost = points.get(i);
            }
            if (topmost == null) {
                topmost = points.get(i);
            }
            if (points.get(i).y > topmost.y) {
                topmost = points.get(i);
            }
            if (points.get(i).y < bottommost.y) {
                bottommost = points.get(i);
            }
            if (points.get(i).x < leftmost.x) {
                leftmost = points.get(i);
            }
            if (points.get(i).x > rightmost.x) {
                rightmost = points.get(i);
            }
        }
        uttermost.add(leftmost);
        uttermost.add(topmost);
        uttermost.add(rightmost);
        uttermost.add(bottommost);
        return uttermost;
    }

}

class Point {

    long x;
    long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

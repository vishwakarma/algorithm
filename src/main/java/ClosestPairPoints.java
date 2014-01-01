package main.java;

/**
 * User: gopi.vishwakarma
 * Date: 02/01/14
 */

import java.util.*;

/**
 * We are given an array of n points in the plane, and the problem is to find out the closest pair of points in the array
 */
public class ClosestPairPoints {
    /**
     * domain class of Cartesian Points e.g : {1,2} etc
     */
    private static class Point {

        int x; // x coordinate
        int y; // y coordinate

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private int getX() {
            return x;
        }
        private int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String args []){
        Point points [] = {new Point(1,2), new Point(2, 3), new Point(12, 30), new Point(40, 50), new Point(5, 1), new Point(12, 10), new Point(3, 4)};

        Arrays.sort(points, new Comparator<Point>() {
            public int compare(Point point1, Point point2) {
                return point1.getY() <= point2.getY() ? -1 : 1;
            }
        });

        double closestDistance = solve(points);

        System.out.println(closestDistance);
    }

    private static double solve(Point[] points) {

        if(points.length <= 3){
            return bruteForce(points, points.length);
        }
        int mid = points.length/2;

        double distanceLeft = solve(Arrays.copyOfRange(points, 0, mid));
        double distanceRight = solve(Arrays.copyOfRange(points, mid, points.length));
        double potentialMinDistance = Math.min(distanceLeft, distanceRight);

        return Math.min(potentialMinDistance, stripClosest(points, potentialMinDistance));

    }

    private static double stripClosest(Point[] points, double potentialMinDistance) {
        Point midPoint = points[points.length/2];
        List<Point> stripArray = new ArrayList<Point>();
        double currentMinDistance = Double.MAX_VALUE;

        for(Point point : points){
            if(Math.abs(point.getX() - midPoint.getX()) < potentialMinDistance){
                stripArray.add(point);
            }
        }
        for(int i=0;i<stripArray.size();i++){
            for(int j=i+1;j<stripArray.size();j++){
                double distance = dist(stripArray.get(i), stripArray.get(j));
                currentMinDistance = Math.min(currentMinDistance, distance);
            }
        }
        return currentMinDistance;
    }

    private static void display(Point[] points){
        for(Point point : points){
            System.out.println(point);
        }
    }
    private static double bruteForce(Point P[], int n){
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; ++j)
                if (dist(P[i], P[j]) < min)
                    min = dist(P[i], P[j]);
        return min;
    }
    private static double dist(Point p1, Point p2){
        return Math.sqrt( (p1.x - p2.x)*(p1.x - p2.x) +
                (p1.y - p2.y)*(p1.y - p2.y)
        );
    }
}

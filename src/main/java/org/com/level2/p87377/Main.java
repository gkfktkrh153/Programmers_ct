package org.com.level2.p87377;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
}
class Solution {
    public int solution(int slice, int n) {

        return 1;
    }

    public Point intersection(int[] line1, int[] line2) {
        double A = line1[0];
        double B = line1[1];
        double E = line1[2];

        double C = line2[0];
        double D = line2[1];
        double F = line2[2];

        double divisor = (A * D) - (B * C);

        if (divisor == 0)
            return null;

        double x = ((B * F)  - (E * D)) / divisor;
        double y = ((E * C)  - (A * F)) / ((A * D) - (B * C));

        if(x != (long)x) return null;
        if(y != (long)y) return null;

        return Point.of((long) y, (long) x);
    }
    public List<Point> intersections(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++){
            for (int j = i + 1; j < line.length; j++){
                Point intersection = intersection(line[i], line[j]);
                if(intersection != null)
                    points.add(intersection);
            }
        }

        return points;
    }
    public Point getMinPoint(Set<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : points) {
            x = Math.min(x, point.x);
            y = Math.min(y, point.y);
        }

        return Point.of(x, y);
    }

    public Point getMaxPoint(Set<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : points) {
            x = Math.max(x, point.x);
            y = Math.max(y, point.y);
        }

        return Point.of(x, y);
    }

    public char[][] emptyMatrix(Set<Point> points) {
        Point minPoint = getMinPoint(points);
        Point maxPoint = getMaxPoint(points);

        long width = maxPoint.x - minPoint.x;
        long height = maxPoint.y - minPoint.y;
        char[][] matrix = new char[(int) (height + 1)][(int) (width + 1)];

        Stream<char[]> stream = Arrays.stream(matrix);


        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, '.'));
        return matrix;
    }
}


class Point{
    public final long x;
    public final long y;

    private Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
    public static Point of(long x, long y){
        return new Point(x,y);
    }
    @Override
    public boolean equals(Object o){
        if(this == o ) return true;
        if(!(o instanceof Point point)) return false;

        if(x != point.x) return false;
            return y == point.y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
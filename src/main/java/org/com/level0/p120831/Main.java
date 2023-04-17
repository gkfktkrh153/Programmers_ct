package org.com.level0.p120831;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] solution = new Solution().solution(new int[][]{
                {0, 1, -1}, {1, 0, -1}, {1, 0, 1}
        });
        for (String s : solution)
            System.out.println(s);
    }
}

class Solution {
    public class Coordinate{
        double y;
        double x;
        public Coordinate(double y, double x){
            this.y = y;
            this.x = x;
        }
        public boolean isInteger() {
            return this.y % 1 == 0.0 && this.x % 1 == 0.0;
        }
    }
    public String[] solution(int[][] line) {
        List<Coordinate> coordinates = new ArrayList<>();


        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;

        for (int i = 0; i < line.length - 1; i++){
            for (int j = i + 1; j < line.length; j++){
                Coordinate meet = meet(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (meet != null) {
                    coordinates.add(meet);
                    maxX = Math.max(maxX, (long)meet.x);
                    minX = Math.min(minX, (long)meet.x);
                    maxY = Math.max(maxY, (long)meet.y);
                    minY = Math.min(minY, (long)meet.y);
                }
            }
        }
        char[][] characters = new char[(int)(maxY - minY + 1)][(int)(maxX - minX + 1)];
        for (int i = 0; i < maxY - minY + 1; i++) {
            for (int j = 0; j < maxX - minX + 1; j++)
                characters[i][j] = '.';
        }

        long aX = 0;
        long aY = 0;
        if (minX < 0)
            aX = Math.abs(minX);
        else if(minX > 0)
            aX = -minX;
        if (minY < 0)
            aY = Math.abs(minY);
        else if(minY > 0)
            aY = -minY;

        for (Coordinate coordinate: coordinates)
            characters[(int)(coordinate.y + aY)][(int)(coordinate.x + aX)] = '*';

        String[] answer = new String[(int)(maxY - minY + 1)];
        for (int i = 0; i < maxY - minY + 1; i++){
            answer[i] = new String(characters[i]);
        }
        return answer;
    }
    public Coordinate meet(double A, double B,double E,double C,double D,double F){
        if ((A * D) - (B * C) == 0)
            return null;
        Double x = ((B * F) - (E * D)) / ((A * D) - (B * C));
        Double y = ((E * C) - (A * F)) / ((A * D) - (B * C));
        Coordinate coordinate = new Coordinate(y, x);
        if (coordinate.isInteger() == true)
            return coordinate;
        else
            return null;
    }
}
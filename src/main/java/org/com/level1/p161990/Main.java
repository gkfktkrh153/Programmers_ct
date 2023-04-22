package org.com.level1.p161990;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{".#...", "..#..", "...#."}));
    }
}

class Solution {
    public int[] solution(String[] wallpaper) {
        char[][] chars = new char[wallpaper.length][];
        for(int  i = 0; i< wallpaper.length;i++){
            chars[i] = wallpaper[i].toCharArray();
        }
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int y = 0; y < chars.length; y++){
            for (int x = 0; x < chars[0].length; x++){
                if(chars[y][x] == '#'){
                    minX = Math.min(minX,x);
                    minY = Math.min(minY,y);
                    maxX = Math.max(maxX,x);
                    maxY = Math.max(maxY,y);
                }
            }
        }
        Arrays.stream(chars).forEach(System.out::println);

        return new int[]{minX,minY,maxX+1,maxY+1};
    }
}

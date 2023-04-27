package org.com.baekjoon.p18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int N = 0;
    static void BFS(int y, int x, int[][] map, int type){

        for (int i = 0; i < 4; i++){
            int nextY = dy[i] + y;
            int nextX = dx[i] + x;
            if(0 <= nextX && nextX < N && 0 <= nextY && nextY < N){ // 범위 내
                if(map[nextY][nextX] == 0)
                    map[nextY][nextX] = type;

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[][] map = new int[N][];
        for(int i = 0 ; i < N; i++) {
            String[] s = br.readLine().split(" ");
            map[i] = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        }
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int S = s[0];
        int Y = s[1];
        int X = s[2];


        //System.out.println(Arrays.deepToString(virus));

        //System.out.println(Arrays.toString(s));

    }
}



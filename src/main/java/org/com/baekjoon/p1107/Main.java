package org.com.baekjoon.p1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int N;
    static int[] ints;
    static int min;
    public static void PER(int selectCount, int targetNum) // 중복순열
    {
        if (list.size() == selectCount){
            int num = Integer.parseInt(list.stream().map(String::valueOf).collect(Collectors.joining()));

            int number = String.valueOf(num).length() + Math.abs(num - targetNum);
            min = Math.min(min, number);

            return;
        }

        for(int i = 0; i < ints.length ; i++){
            list.add(ints[i]);
            PER(selectCount, targetNum);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> button = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        int targetNum = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        if (n > 0) {
            int[] removeButton = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i = 0; i < n; i++)
                button.remove(Integer.valueOf(removeButton[i]));
        }

        min = Math.abs(100 - targetNum);
        ints = button.stream().mapToInt(Integer::intValue).toArray();

        for (int i =1 ; i <= 7;i++)
            PER(i, targetNum);

        System.out.println(min);
        // 타켓넘버는 100인데 버튼이 100을 못만들게끔 주어질 수 있음
    }
}

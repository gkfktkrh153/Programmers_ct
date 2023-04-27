package org.com.level2.p42586;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        for(int i = 0; i < progresses.length;i++)
            index.add(i);
        int num = 0;
        boolean[] complete = new boolean[progresses.length];
        Arrays.fill(complete, false);

        int firstIndex = 0;
        while(num < progresses.length) {

            if (progresses[index.get(0)] >= 100) { // 첫번째 기능이 구현됐다면
                firstIndex = index.get(0);

                int count = 0;
                for (int j = firstIndex; j < progresses.length; j++) {
                    if (complete[j] == false && progresses[j] >= 100) {
                        complete[j] = true;
                        index.remove(Integer.valueOf(j));
                        count += 1;
                    }
                    else
                        break;
                }
                answer.add(count);
                num += count;
            }
            else {
                for (int i = 0; i < progresses.length; i++)
                    progresses[i] += speeds[i];
            }


        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
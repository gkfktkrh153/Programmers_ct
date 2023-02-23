package org.com.level0.p120824;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 4, 5}));
    }
}
class Solution {
    public ArrayList<Integer> solution(int[] num_list) {
        ArrayList<Integer> answer = new ArrayList<>();
        int odd = 0, even = 0;

        for (int num : num_list){
            if (num % 2 == 1){ // 훌수
                odd += 1;
            }
            else
                even += 1;
        }

        answer.add(even);
        answer.add(odd);
        return answer;
    }
}

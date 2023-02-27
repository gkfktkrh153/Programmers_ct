package org.com.level0.p120809;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] {1,2,3,4,5}));
    }
}

class Solution {
    public ArrayList<Integer> solution (int[] numbers) {
        ArrayList<Integer> answers = new ArrayList<>();
        for (int i : numbers){
            answers.add(i * 2);
        }

        return answers;

    }
}

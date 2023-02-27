package org.com.level0.p120813;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new int[] {1,2,3,4,5});
    }
}

class Solution {
    public ArrayList<Integer> solution(int n) {

        ArrayList<Integer> answers = new ArrayList<>();
        for(int i = 1; i <= n; i++)
        {
            if (i % 2 == 1){
                answers.add(i);
            }
        }
        return answers;
    }
}
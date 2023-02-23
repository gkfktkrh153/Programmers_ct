package com.ll.level0.p120817;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}

class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for(double number : numbers){
            answer += number;
        }
        return answer/ numbers.length;
    }
}
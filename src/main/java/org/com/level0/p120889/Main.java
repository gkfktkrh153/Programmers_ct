package org.com.level0.p120889;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{199, 72, 222}));
    }
}

class Solution {
    public int solution(int[] sides) {
        ArrayList<Integer> integers = new ArrayList<>();
        int max = Arrays.stream(sides).max().getAsInt();
        int sum = Arrays.stream(sides).sum();

        if (max < sum - max)
            return 1;
        else
            return 2;
    }
}
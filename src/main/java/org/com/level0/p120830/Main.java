package org.com.level0.p120830;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(13,2));
    }
}
class Solution {
    public int solution(int n, int k) {
        return n * 12000 + k * 2000 - (n / 10) * 2000;
    }
}
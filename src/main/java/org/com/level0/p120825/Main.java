package org.com.level0.p120825;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("hello", 3));
    }
}
class Solution {
    public String solution(String my_string, int n) {
        String answer = "";

        for(String s : my_string.split("")){
            for(int i = 0; i < n; i++){
                answer += s;
            }
        }

        return answer;
    }
}
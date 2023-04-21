package org.com.level1.p76501;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{4,7,12}, new boolean[]{true,false, true}));
    }
}
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < signs.length; i++){
            if(signs[i] == true)
                answer += absolutes[i];
            else
                answer -= absolutes[i];

        }
        return answer;
    }
}
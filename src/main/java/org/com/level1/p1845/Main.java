package org.com.level1.p1845;

public class Main {
}

class Solution {
    public int solution(int[] nums) {
        boolean  isSelected[] = new boolean[200001];
        int answer = 0;
        for(int i = 0; i < nums.length;i++)
        {
            if(answer == nums.length/2)
                break;
            if(isSelected[nums[i]] == false)
            {
                isSelected[nums[i]] = true;
                answer++; //포켓몬 종류
            }

        }

        return answer;
    }
}
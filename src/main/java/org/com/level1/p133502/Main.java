package org.com.level1.p133502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }
}
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> lst = new ArrayList<>();


        for(int i : ingredient){
            lst.add(i);

            if (lst.size() >= 4){
                if(lst.get(lst.size() -1)  == 1 &&
                   lst.get(lst.size() -2)  == 3 &&
                   lst.get(lst.size() -3)  == 2 &&
                   lst.get(lst.size() -4)  == 1)
                {
                    for (int k = 0; k < 4; k++)
                        lst.remove(lst.size()-1);
                    answer += 1;
                }

            }
        }

        return answer;
    }
}
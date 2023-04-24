package org.com.level1.p133502;

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
        List<Integer> lst
                = Arrays.stream(ingredient)
                .boxed()
                .collect(Collectors.toList());

        int current = 0; // 현재 위치
        int count = 0;
        int answer = 0;
        int before = 0;
        while(true){
            if (lst.get(current) == 1) { // 내가 빵이라면
                if (current - 3 >= 0){
                    int index = current - 3;
                    boolean flag = true;
                    for(int i = 1; i <= 3; i++){
                        if (lst.get(index) != i) // 순서에 맞지 않다면
                            flag = false;
                        index += 1;
                    }
                    if (flag == true) { // 햄버거 완성
                        answer += 1;
                        index -= 3;
                        for (int i = 0; i < 4; i++)
                            lst.remove(index);
                        current -= 4;
                    }

                }
            }
            if (current == lst.size() - 1)
                break;
            current += 1;
        }



        return answer;
    }
}
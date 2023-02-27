package org.com.level0.p120821;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] {1,2,3,4,5}));
    }
}
class Solution {
    public Integer[] solution(int[] num_list) {
        Integer[] arr = Arrays.stream(num_list).boxed().toArray(Integer[]::new);
        Collections.reverse(Arrays.asList(arr));


        return arr;
    }
}

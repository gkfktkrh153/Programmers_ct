package org.com.pccp.p1;

import java.util.*;

public class Main {
}

class Solution {
    public String solution(String input_string) {
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i < input_string.length();i++){
            if (i == input_string.length() - 1){
                if(map.get(input_string.charAt(i)) != null)
                    set.add(input_string.charAt(i));
            }
            else{
                if(input_string.charAt(i) == input_string.charAt(i+1))
                    continue;
                if(map.get(input_string.charAt(i)) == null){

                    map.put(input_string.charAt(i), 1);
                }
                else
                    set.add(input_string.charAt(i));

            }
        }

        set.stream().sorted().forEach(ch -> sb.append(ch));
        if (sb.toString().equals(""))
            return "N";
        return sb.toString();
    }
}
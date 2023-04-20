package org.com.level1.p12948;

public class Main {
    public static void main(String[] args) {
        new Solution().solution("01033334444");
    }

}
class Solution {
    public String solution(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }
}

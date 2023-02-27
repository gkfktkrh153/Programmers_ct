package org.com.level0.p120816;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int solution(int slice, int n) {

        int answer = 1;
        while (true){
            if (answer * slice >= n){
                return answer;
            }
        }
    }
}

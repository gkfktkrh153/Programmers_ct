package org.com.baekjoon.p4889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        String str;
        while (!(str = reader.readLine()).contains("-")) {

            System.out.println(String.format("%d. %d", count, new Solution().solution(str)));
            count += 1;
        }
    }
}

class Solution{
    int solution(String str){
        int answer = 0;
        char[] chars = str.toCharArray();
        Stack<Character> stack1 = new Stack<>();
        for(char c : chars){
            stack1.push(c);
            if (stack1.size() >= 2){
                if (stack1.get(stack1.size() - 2) == '{' &&stack1.get(stack1.size() - 1) == '}'){
                    stack1.pop();
                    stack1.pop();
                }
            }
        }
        while(stack1.size() > 0){
            if(stack1.get(stack1.size() - 1) == '{' && stack1.get(stack1.size() - 2) == '{')
                answer += 1;
            else if(stack1.get(stack1.size() - 1) == '}' && stack1.get(stack1.size() - 2) == '}')
                answer += 1;
            else
                answer += 2;
            stack1.pop();
            stack1.pop();
        }

        return answer;
    }
}

// 1. 처음에 들어온 올바른 괄호 제거
// 2. 다음 케이스들 하나씩 처리
// }}
// {{
// }{
// }}}}{{{{
// }{{{
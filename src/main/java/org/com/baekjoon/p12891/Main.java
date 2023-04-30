package org.com.baekjoon.p12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*

DNA 문자열 길이, 부분문자열 길이
부분 문자열
ACGT 포함해야하는 개수
 */
public class Main {
    public static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] length = br.readLine().split(" ");
        int dnaLength = Integer.parseInt(length[0]);
        int partLength = Integer.parseInt(length[1]);

        String str = br.readLine();
        int[] countOfDnaString = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String firstPassword = str.substring(0, partLength - 1);

        HashMap<String,Integer> countOfPartString = new HashMap<>();
        countOfPartString.put("A", countChar(firstPassword, 'A'));
        countOfPartString.put("C", countChar(firstPassword, 'C'));
        countOfPartString.put("G", countChar(firstPassword, 'G'));
        countOfPartString.put("T", countChar(firstPassword, 'T'));

        String a = Character.toString('A');
        for(int i = 0; i <= dnaLength - partLength; i++){
            String lastChar = Character.toString(str.charAt(i + partLength - 1));


            countOfPartString.put(lastChar, countOfPartString.get(lastChar) + 1);
            if( countOfPartString.get("A") >= countOfDnaString[0]
                &&
                countOfPartString.get("C") >= countOfDnaString[1]
                &&
                countOfPartString.get("G") >= countOfDnaString[2]
                &&
                countOfPartString.get("T") >= countOfDnaString[3]
            )
                answer += 1;

            String firstChar = Character.toString(str.charAt(i));
            countOfPartString.put(firstChar, countOfPartString.get(firstChar) - 1);
        }
        System.out.println(answer);
    }
}

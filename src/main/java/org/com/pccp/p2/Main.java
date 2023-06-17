package org.com.pccp.p2;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.XMLFormatter;
import java.util.Arrays;
public class Main {
    static Integer[] member;
    static Integer[] sports;
    static boolean[] visitedMember;
    static boolean[] visitedSports;
    static int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
    static int max_sum = 0;
    public static void main(String[] args) {
        ability = new int[ability.length][ability[0].length];

        member = new Integer[ability.length];
        for (int i = 0; i < ability.length; i++)
            member[i] = i;
        visitedMember = new boolean[ability.length];

        combination(new Stack<>(), 3, 0);
        System.out.println(max_sum);
    }


    public static void combination(Stack<Integer> stack, int r, int depth) {
        if (stack.size() == r) {
            System.out.println("member: " + stack.toString());
            sports = new Integer[stack.size()];
            for (int i = 0; i < stack.size(); i++)
                sports[i] = stack.get(i);
            visitedSports = new boolean[sports.length];

            permutation(new Stack<>(), 3, 0);
            return;
        }

        for (int i = depth; i < member.length; i++) {
            if (visitedMember[i] == false) {
                stack.push(member[i]);
                visitedMember[i] = true;
                combination(stack, r, i);
                visitedMember[i] = false;
                stack.pop();

            }
        }
    }

    public static void permutation(Stack<Integer> stack, int r, int depth) {
        if (stack.size() == r) {
            int sum = 0;
            System.out.println(stack.toString());
            for (int i = 0; i < stack.size(); i++) {
                sum += ability[stack.get(i)][i];
            }
            if(max_sum < sum)
                max_sum = sum;

            return;
        }

        for (int i = 0; i < sports.length; i++) {
            if (visitedSports[i] == false) {
                stack.push(sports[i]);
                visitedSports[i] = true;
                permutation(stack, r, depth + 1);
                visitedSports[i] = false;
                stack.pop();

            }
        }
    }
}
/*    combination 0 | for
    combination 1 | for 1
    1 2
    1 3
    combination 2 return

    combination 1 | for 2
    2 1
    2 3
    combination 2 return

        combination 1 | for 2
    3 1
    3 2
    combination 2 return
*/



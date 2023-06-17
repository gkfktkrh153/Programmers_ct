import java.util.Stack;
import java.util.Arrays;
class Solution {
    public static void main(String[] args) {

    }
    static int max_sum = 0;
    static boolean[] visitedMember;
    public int solution(int[][] ability) {

        visitedMember = new boolean[ability.length];
        permutation(ability[0].length, 0, ability, 0); // 종목 수 만큼 학생을 고름

        return max_sum;

    }


    public static void permutation(int r, int depth, int[][] ability,int sum) {
        if (depth == r) {
            if(max_sum < sum)
                max_sum = sum;

            return;
        }

        for (int i = 0; i < ability.length; i++) {
            if (visitedMember[i] == false) {
                visitedMember[i] = true;
                permutation(r, depth + 1, ability, sum + ability[i][depth]);
                visitedMember[i] = false;

            }
        }
    }

}
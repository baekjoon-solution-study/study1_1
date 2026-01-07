import java.io.*;
import java.util.*;

/**
 * 9251
 *
 * LCS 문제 처음 접해서 3시간 걸림.
 * 풀긴 했지만 힌트 받아서 해결했고 그마저도 잘못된 접근이였음.
 * 다시 풀어볼 문제
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String first = br.readLine();
        String second = br.readLine();

        char[] firstArray = new char[first.length() + 1];
        char[] secondArray = new char[second.length() + 1];
        for (int i = 1; i <= first.length(); i++) {
            firstArray[i] = first.charAt(i - 1);
        }
        for (int i = 1; i <= second.length(); i++) {
            secondArray[i] = second.charAt(i - 1);
        }

        int f = solve(firstArray, secondArray);
        System.out.println(f);
    }


    static int solve(char[] first, char[] second) {
        int[][] dp = new int[first.length][second.length];

        for (int i = 1; i < first.length; i++) {
            int max = 0;
            for (int j = 1; j < second.length; j++) {
                max = Math.max(max, dp[i - 1][j - 1]);
                if (first[i] == second[j]) {
                    dp[i][j] = max + 1;
                }
                else {
                     dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int max = 0;
        for (int i : dp[first.length - 1]) {
            max = Math.max(max, i);
        }
        return max;
    }


}

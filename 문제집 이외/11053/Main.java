import java.io.*;
import java.util.*;

/**
 * 11053
 *
 * LIS 문제
 * 2차원 쓸 필요 없이 1차원 DP로 해결 가능함.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer line = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        int temp = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(line.nextToken());
            temp = Math.max(temp, arr[i]);
        }

        int[][] dp = new int[N + 1][temp + 1];

        for (int i = 1; i <= N; i++) {  // 50 40 30 20 31 41 51 61
            int max = 0;
            for (int j = 1; j <= temp; j++) {
                if (j == arr[i]) {
                    dp[i][j] = max + 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
                max = Math.max(max, dp[i - 1][j]);
            }

        }
        int max = 0;
        for (int i : dp[N]) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}

import java.io.*;
import java.util.*;

/**
 * 1932
 *
 * 전형적인 2차원 DP 문제
 * 어려울게 없음.
 */

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int i = 1; i < N; i++) {
            int[] cur = arr[i];
            for (int j = 0; j <= i; j++) {  // i번째에는 i개의 요소가 존재함.

                if (j == 0) {
                    dp[i][j] = arr[i][j] + dp[i - 1][0];
                }
                else if (j == cur.length - 1) {
                    dp[i][j] = arr[i][j] + dp[i - 1][cur.length - 2];
                }
                else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        int max = dp[N - 1][0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }
        System.out.println(max);
    }
}
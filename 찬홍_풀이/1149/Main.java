import java.io.*;
import java.util.*;

/**
 * 7576
 * 3차원 bfs 문제.
 * 오히려 구현이 까다로웠음. 알고리즘 파악은 금방함.
 * 초기값에 여러개 넣는 형식도 있음을 알아야함.
 *
 */

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            int[] cur = arr[i];
            dp[i][0] = cur[0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cur[1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cur[2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }


        int min = dp[N - 1][0];
        for (int i = 1; i < 3; i++) {
            min = Math.min(min, dp[N - 1][i]);
        }
        System.out.println(min);
    }
}
import java.io.*;
import java.util.*;

/**
 * 전형적인 DP

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M  = Integer.parseInt(br.readLine());
            int[][] arr = new int[M][2];
            int[][] dp = new int[M][2];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                arr[k][0] = Integer.parseInt(st1.nextToken());
                arr[k][1] = Integer.parseInt(st2.nextToken());
            }

            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];
            if (M > 1) {
                dp[1][0] = arr[1][0] + dp[0][1];
                dp[1][1] = arr[1][1] + dp[0][0];
            }

            for (int j = 2; j < M; j++) {
                int up = Math.max(dp[j - 1][1], dp[j - 2][1]);
                int down = Math.max(dp[j - 1][0], dp[j - 2][0]);

                dp[j][0] = arr[j][0] + up;
                dp[j][1] = arr[j][1] + down;
            }
            sb.append(Math.max(dp[M - 1][0], dp[M - 1][1])).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
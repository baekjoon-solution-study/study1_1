import java.io.*;
import java.util.*;

/**

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            
            if (i == 0) {
                if (weight > M) continue;
                dp[i][weight] = value;
            }
            else {
                int[] past = dp[i - 1];
                for (int j = 1; j <= M; j++) {
                    dp[i][j] = past[j];
                }
                if (weight > M) continue;
                for (int k = 1; k <= M; k++) {
                    if (past[k] != 0 && k + weight <= M) {
                        dp[i][k + weight] = Math.max(past[k + weight], value + past[k]);
                    }
                }
                dp[i][weight] = Math.max(past[weight], value);

            }
        }

        int max = 0;
        for (int i : dp[N - 1]) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
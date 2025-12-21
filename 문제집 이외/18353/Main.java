import java.io.*;
import java.util.*;

/**
 * 18353
 * 줄세우기 문제. DP문제인지 몰랐음.
 * 전형적인 패턴이므로 꼭 기억할 것.
 */

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[k];
        for (int i = 0; i < k; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            dp[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(k - ans);
    }



}

import java.io.*;
import java.util.*;

/**
 * 2133
 *
 * 개어려움.
 * 특이 타일이 3 * 4 뿐만 아닌 3 * 6 에도 존재하고 3 * n 인 경우 n - 2 타일에 대해 특이 타일이 또 존재함.
 * 못풀어서 힌트 보고 해결.
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 3 * 1 = 0,
        // 3 * 2 = 3,
        // 3 * 3 = 0,
        // 3 * 4 = 3 * 3 + 2 = 11,
        // 3 * 5 = 0,
        // 3 * 6 = 3 * 3 * 3 + 3 * 2 * 2 = 39, (끝이 3 * 2인 경우 3 * 11 + 끝이 3 * 4인 경우 2 * 3,  3 * 6 특이 타일 2개 = 41
        // 3 * 8 = (3 * 2 가 4개, 3 * 6 + 3 * 2 1개, 3 * 4 2개 타일) 3^4 + 3 * 2 * 3^2 + 2 * 2
        // 3 * 10 = (3 * 2 5개, 3 * 2 + 3 * 8 1개, 3 * 4 + 3 * 6 1개) 3^5 + 4 * 2 * 3^3 +

        long[] dp = new long[31];
        dp[0] = 1;
        dp[2] = 3;
        dp[4] = 11;
        // dp[6] = 33 + 6 + 2

        for (int i = 6; i <= 30; i++) {
            if (i % 2 == 0) {
                dp[i] += 3 * dp[i - 2];
                for (int j = i - 4; j >= 0; j-= 2) {
                    dp[i] += 2 * dp[j];
                }
            }
        }
       /* for (long i : dp) {
            System.out.print(i + " ");
        }*/
        System.out.println(dp[Integer.parseInt(br.readLine())]);
    }
}

import java.io.*;
import java.util.*;

/**
 * 9461
 *
 * 그냥 규칙 찾아서 해결.
 * dp 아닌듯. 그리디 같은디
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 1 1 2 2 3(1 + 2) 4(1 + 3) 5(4 + 1) 7(2 + 5) 9(2 + 7) 12(3 + 9) 16 21

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 5] + dp[i - 1];
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(dp[input]);
        }

    }
}

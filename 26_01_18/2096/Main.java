import java.io.*;
import java.util.*;

/**
 * 15686번
 *
 * 순열 / 조합 을 잘 이용해야함.
 * 이 문제는 순열로 접근하면 시간초과 100% 터짐.
 * 반드시 조합을 이용해야함.
 * 특히 for문에서 start 를 사용해서 이후에 뽑을 놈들은 index가 처음보다 큰 놈만 뽑게 만들면 됨.
 **/


public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[3];
        int[] dp_min = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (i == 0) {
                dp[0] = x;
                dp[1] = y;
                dp[2] = z;
                dp_min[0] = x;
                dp_min[1] = y;
                dp_min[2] = z;
            }
            else {
                int dp_1 = Math.max(dp[0], dp[1]) + x;
                int dp_2 = Math.max(Math.max(dp[0], dp[1]), dp[2]) + y;
                int dp_3 = Math.max(dp[1], dp[2]) + z;

                int dp_min_1 = Math.min(dp_min[0], dp_min[1]) + x;
                int dp_min_2 = Math.min(Math.min(dp_min[0], dp_min[1]), dp_min[2]) + y;
                int dp_min_3 = Math.min(dp_min[1], dp_min[2]) + z;

                dp[0] = dp_1;
                dp[1] = dp_2;
                dp[2] = dp_3;
                dp_min[0] =  dp_min_1;
                dp_min[1] = dp_min_2;
                dp_min[2] = dp_min_3;
            }
        }

        int max = Math.max(Math.max(dp[0], dp[1]), dp[2]);
        int min = Math.min(Math.min(dp_min[0], dp_min[1]), dp_min[2]);
        System.out.println(max + " " + min);
    }
}

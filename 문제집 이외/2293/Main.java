import java.io.*;
import java.util.*;

/**
 * 2293
 *
 * 배낭문제와 약간 비슷함.
 * 동전 1개를 전부 배치 후 다음 동전도 배치하며 가짓 수 dp 테이블을 추가하는 방식.
 * 예를 들어 동전이 2 라면 dp[4] 에 접근 할 경우 dp[2] 에 모든 경우를 만든 후 이동해야 함.
 **/

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[M + 1];
        dp[0] = 1;
        // 1 1 1 1 1 1 1 1 1 1
        // 0 1 0 1 0 1 0 1 0 1
        // 1 2 1 2 1 2 1 2 1 2
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i] <= j) {
                   dp[j] += dp[j - arr[i]];
                }

            }
        }

        System.out.println(dp[M]);
    }



}

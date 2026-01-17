import java.io.*;
import java.util.*;

/**
 * 2011
 *
 * 예외 케이스 처리에서 많이 틀림.
 * dp는 1차원으로 충분함.
 * 현재가 i 번째 일 경우 0보다 크면 이전 dp의 경우의 수를 전부 가져옴. i - 1, i 번째를 합쳐서 10 ~ 26 사이라면 i - 2 번째의 경우의 수도 가져옴.
**/

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 22114 / 1 2 3 5
        String line = br.readLine();
        if (line.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        int[] arr = new int[line.length() + 1];
        int[] dp = new int[line.length() + 1];
        for (int i = 1; i <= line.length(); i++) {
            arr[i] = line.charAt(i - 1) - '0';
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= line.length(); i++) {
            if (arr[i] > 0) dp[i] = dp[i - 1];
            if (arr[i - 1] == 1 || arr[i - 1] == 2 && arr [i] <= 6) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }
            if (dp[i] == 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(dp[line.length()]);
    }
}

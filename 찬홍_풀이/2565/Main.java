import java.io.*;
import java.util.*;

/**
 * 2565
 *
 * 그리디로 풀면 큰일남. 매번 큰 값을 고르다 많은 전기줄을 고를 수 없을 수 있음.
 * DP로 해결
 * 그리고, DP 배열의 크기를 전기줄의 크기로 해야지 노드의 수로 하면 큰일남. 전기줄의 크기가 100인데 노드의 수가 1억이면 메모리 초과함.
 */

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        list.sort((o1, o2) -> o1[0] - o2[0]);

        int[] dp = new int[n];

        /*
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i)[1];
            int count = 1;
            for (int j = i + 1; j < list.size(); j++) {
                if (temp < list.get(j)[1]) {
                    temp = list.get(j)[1];
                    count++;
                }
            }
            dp[list.get(i)[0]] = count;
        }

         */
        // 1 4 6 5 8
        for (int i = 0; i < list.size(); i++) {
            dp[i] = 1;
            int temp = list.get(i)[1];
            for (int j = 0; j < i; j++) {
                if (list.get(j)[1] < temp) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i : dp) max = Math.max(max, i);
        System.out.println(n - max);
    }



}

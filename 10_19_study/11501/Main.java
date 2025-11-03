import java.io.*;
import java.util.*;

/**
 * 해결 못해서 도움받음. 배열 0 index 부터 순회하니 O(n^2) 나오고 어려워짐.
 * 최대 값을 기준으로 현재 팔건지 살건지가 정해짐. -> 역방향으로 순회하면 가능함.
 */

public class Main {


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            int[] arr = new int[M];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[j] = Integer.parseInt(st.nextToken());

            }
            long max = arr[arr.length - 1];
            long benefit = 0;

            for (int j = arr.length - 2; j >= 0; j--) {
                if (max > arr[j]) {
                    benefit += max - arr[j];
                }
                else {
                    max = arr[j];
                }
            }
            sb.append(benefit).append("\n");
        }
        if (sb.length() > 0) sb.delete(sb.length() - 1, sb.length());
        bw.write(sb.toString());
        bw.flush();

    }

}
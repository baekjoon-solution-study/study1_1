import java.io.*;
import java.util.*;

/**
 * 2805
 *
 * 전형적인 이분탐색.
 * 자료형에 신경쓸 것
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }


        long left = 0;
        long right = max;
        while (left <= right) {
            long mid = (left + right) / 2;
            long temp = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    temp += (arr[i] - mid);
                }
            }
            if (temp < M) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
}
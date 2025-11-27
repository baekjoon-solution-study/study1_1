import java.io.*;
import java.util.*;

/**
 * 2110
 *
 * 탐색할 요소가 arr의 요소인지 아니면 다른 값인지 먼저 판단해야함.
 * arr의 요소라면 index 값을 left, right로 이용하고
 * arr의 차이라던지 합은 arr[]요소 값 자체를 이용함.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long left = 0;
        long right = arr[N - 1];
        while (left <= right) {
            long mid = (right + left) / 2;
            int count = 1;
            int cur = 0;
            for (int i = 1; i < N; i++) {
                if (mid <= arr[i] - arr[cur]) {
                    count++;
                    cur = i;
                }
            }
            if (count < M) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            //System.out.println(count + " " + left + " " + right);
        }
        System.out.println(right);
    }
}
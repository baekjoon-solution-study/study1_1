import java.io.*;
import java.util.*;

/**
 * 예전에 푼 적이 있어서 금방 품.
 * 반복문의 크기가 커지며 이분탐색으로 해결
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        long low = 1;
        long high = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > high) {
                high = arr[i];
            }
        }

        while (low <= high) {
            long count = 0;
            long mid = (low + high) / 2;
            for (int i = 0; i < N; i++) {
                count += arr[i] / mid;
            }
            if (count >= M) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

        }
        System.out.println(low - 1);
    }

}
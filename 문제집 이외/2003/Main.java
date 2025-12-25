import java.io.*;
import java.util.*;

/**
 * 2003
 *
 * 투포인터 문제이다.
 * 1칸씩 움직이는게 코드짜기 훨씬 쉽다는걸 명심.
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
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        /*
        int cnt = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (left < N) {
            while (sum < M && right < N) {
                sum += arr[right++];
            }
            while (sum > M && left < N) {
                sum -= arr[left++];
            }
            if (sum == M) {
                //System.out.println(left + " " + right);
                cnt++;
                sum -= arr[left++];
                if (right < N) {
                    sum += arr[right++];
                }
            }
            else if (sum < M && right >= N) break;
        }

         */
        /**
         * 이렇게 1칸씩 움직이는게 훨씬 직관적이고 쉽다.
         */
        int cnt = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (true) {
            if (sum >= M) {
                if (sum == M) cnt++;
                sum -= arr[left++];
            }
            else if (right == N) {
                break;
            }
            else {
                sum += arr[right++];
            }

        }

        System.out.println(cnt);
    }
}

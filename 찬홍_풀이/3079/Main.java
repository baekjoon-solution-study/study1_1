import java.io.*;
import java.util.*;

/**
 * 3079
 *
 * 처음보면 이분탐색 문제인지 모를듯.
 * 이분탐색인걸 알고봐도 처음엔 잘 몰랐고 시간을 기준으로 검증하니 이분탐색임을 찾음.
 * left, right 값 변경하는 코드, 검증 코드 이 둘을 잘 분리해야함.
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

        /*
        long left = 1;
        long right = arr[0] * M;
        long ans = 0;
        while (left <= right) {
            long mid = (right + left) / 2;
            long count = 0;
            for (int i = 0; i < N; i++) {
                count += (mid / arr[i]);
                if (count > M || count == M) {
                    right = mid - 1;
                    ans = mid;
                    break;
                }
            }
            //System.out.println(left + " " + right + " " + count);
            if (count < M) {
                left = mid + 1;

            }
        }
         */
        /**
         * 이렇게 깔끔하게 로직을 분리해야 디버깅이 쉬움.
         */
        long left = 1;
        long right = arr[0] * M;
        long ans = 0;
        while (left <= right) {
            long mid = (right + left) / 2;
            long count = 0;
            for (int i = 0; i < N; i++) {  // 검증 코드
                count += (mid / arr[i]);
                if (count >= M) break;
            }

            if (count >= M) {  // 범위 변경 코드
                right = mid - 1;
                ans = mid;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
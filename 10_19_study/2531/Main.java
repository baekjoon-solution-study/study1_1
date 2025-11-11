import java.io.*;
import java.util.*;

/**
 * 투포인터 문제를 금방 깨달았지만 구현하는데 오래걸림 ㅅㅂ
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int type = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());
        int[] counts = new int[type + 1];

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < K; i++) {  // 초기값 세팅
            counts[arr[i]]++;
        }

        int max = 0;
        for (int i = 0; i < type + 1; i++) {
            if (counts[i] > 0) max++;
        }

        int last = max;
        if (counts[coupon] == 0)  {
            max++;
            last = max - 1;
        }

        int lastIdx = K;
        for (int i = 1; i < N; i++) {

            if (lastIdx == N) lastIdx = 0;
            if (arr[i - 1] == arr[lastIdx]) {
                lastIdx++;
                continue;
            }

            if (counts[arr[i - 1]] == 1) {
                last--;
            }
            counts[arr[i - 1]]--;

            if (counts[arr[lastIdx]] == 0) {
                last++;
            }
            counts[arr[lastIdx]]++;

            if (counts[coupon] == 0){
                max = Math.max(max, last + 1);  // 쿠폰 적용
            }
            else {
                max = Math.max(max, last);
            }
            lastIdx++;
        }
        System.out.println(max);

    }

}
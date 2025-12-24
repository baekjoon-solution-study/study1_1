import java.io.*;
import java.util.*;

/**
 * 12015
 *
 * 배열의 크기가 1,000,000 이므로 기존 LIS 로 풀면 O(N^2) 이므로 시간초과됨.
 * 밑의 코드는 실제 LIS 배열을 찾는건 아님. Length를 찾기는 맞음.
 * 값 바꿔치기를 하므로 dp[] 는 실제 LIS 가 아님을 유의.
 **/

public class Main {

    static StringBuilder sb;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> dp = new ArrayList<>();
        dp.add(arr[0]);
        int last = dp.get(0);

        for (int i = 1; i < n; i++) { // 5 6 7 5 6 7 8
            if (arr[i] > last) {
                dp.add(arr[i]);
            }
            else {

                int left = 0;
                int right = dp.size() - 1;
                int ans = 0;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arr[i] > dp.get(mid)) {
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                        ans = mid;
                    }
                }
                dp.set(ans, arr[i]);
            }
            last =  dp.get(dp.size() - 1);

        }
        System.out.println(dp.size());

    }
}

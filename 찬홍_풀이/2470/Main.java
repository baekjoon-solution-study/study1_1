import java.io.*;
import java.util.*;

/**
 * 2470
 *
 * for문 돌리며 내부에서 이분탐색을 했지만 left, right 움직이는 로직을 잘못짜서 실패함.
 * 더 좋은 풀이로 합이 음수면 left++, 양수면 right-- 로 좁혀가는 방법을 이용.
 * 틀린 이유는 음수면 left++, 양수면 right-- 을 이용하지 않아서 이분탐색에 오류가 계속 발생했음.
 **/

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int value = Math.abs(arr[left] + arr[right]);
        int[] result = new int[2];
        while (left < right) {
            int add = arr[left] + arr[right];
            if (Math.abs(add) <= value) {
                value = Math.abs(add);
                result[0] = left;
                result[1] = right;
            }
            if (add < 0) {
                left++;
            }
            else if (add > 0) {
                right--;
            }
            else {
                System.out.println(arr[left] + " " + arr[right]);
                return;
            }

        }
        System.out.println(arr[result[0]] + " " + arr[result[1]]);
    }
}

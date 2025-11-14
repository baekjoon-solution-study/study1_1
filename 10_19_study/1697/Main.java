import java.io.*;
import java.util.*;

/**
 * 계산으로 풀다가 실패함.
 * DP 로 시도하다 실패함.
 * 알고리즘 유형보고 겨우 품.
 * DFS 의 이해가 아직 부족한 듯. 이 문제는 꼭 다시 풀어볼 것
 */

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 5 67
        // 5, 10, 20, 40, 39, 38, 37, 36, 35, 34, 68, 67

        // 5 90
        // 5, 10, 11, 22, 44, 45, 90

        // 5 41
        // 5, 10, 20, 40, 41
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int length = Math.max(N, M);
        arr = new int[length * 2 + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = N - i;
        }
        for (int i = N + 1; i < arr.length; i++) {
            arr[i] = i - N;
        }

        int result = bfs(N, M);
        System.out.println(result);
    }
    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {

            int idx = queue.poll();
            if (idx == end) break;
            int[] temp = new int[3];
            temp[0] = idx * 2;
            temp[1] = idx + 1;
            temp[2] = idx - 1;

            if (idx <= end) {
                for (int i : temp) {
                    if (i >= 0 && i < arr.length && arr[i] >= arr[idx] + 1) {
                        queue.add(i);
                        arr[i] = arr[idx] + 1;
                    }
                }
            }
            else {
                if (idx < arr.length && arr[idx - 1] > arr[idx] + 1) {
                    queue.add(idx - 1);
                    arr[idx - 1] = arr[idx] + 1;
                }
            }

        }
        return arr[end];
    }
}
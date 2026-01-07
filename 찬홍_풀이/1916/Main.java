import java.io.*;
import java.util.*;

/**
 * 1916
 *
 * 아주 전형적인 다익스트라 문제.
 **/


public class Main {

    static StringBuilder sb;
    static List<int[]>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[x].add(new int[] {y, weight});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int current = cur[0];
            int current_weight = cur[1];
            if (result[current] < current_weight) continue;

            for (int i = 0; i < arr[current].size(); i++) {
                int[] next = arr[current].get(i);
                if (current_weight + next[1] < result[next[0]]) {
                    result[next[0]] = current_weight + next[1];
                    pq.add(new int[] {next[0], result[next[0]]});
                }
            }
        }
        System.out.println(result[end]);
    }
}

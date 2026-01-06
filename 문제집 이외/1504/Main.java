import java.io.*;
import java.util.*;

/**
 * 1504
 *
 * 다시 풀어라.
 */

public class Main {

    static StringBuilder sb;
    static List<List<int[]>> group;
    static long[] value;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        group = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            group.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            group.get(x).add(new int[] {y, weight});
            group.get(y).add(new int[] {x, weight});
        }

        st = new StringTokenizer(br.readLine());
        int[] vertex = new int[2];
        vertex[0] = Integer.parseInt(st.nextToken());
        vertex[1] = Integer.parseInt(st.nextToken());

        value = new long[N + 1];

        long result = graph(1, vertex[0]) + graph(vertex[0], vertex[1]) + graph(vertex[1], N);
        long temp = graph(1, vertex[1]) + graph(vertex[1],  vertex[0]) + graph(vertex[0], N);

        result = Math.min(result, temp);
        if (result < Integer.MAX_VALUE) {
            System.out.println(result);
        }
        else {
            System.out.println(-1);
        }

    }
    static long graph(int start, int end) {

        if (start == end) return 0;
        for (int i = 1; i <= N; i++) {
            value[i] = Integer.MAX_VALUE;
        }
        value[start] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[] {0, start});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_start = cur[1];

            for (int i = 0; i < group.get(cur_start).size(); i++) {
                int next = group.get(cur_start).get(i)[0];
                int weight = group.get(cur_start).get(i)[1];
                if (value[cur_start] + weight < value[next]) {
                    value[next] = value[cur_start] + weight;
                    q.add(new int[] {weight, next});
                }
            }
        }
        return value[end];
    }
}

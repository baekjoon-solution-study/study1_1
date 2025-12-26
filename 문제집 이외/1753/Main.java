import java.io.*;
import java.util.*;

/**
 * 1753
 *
 * 다익스트라 구현 문제.
 * 우선순위 큐 이용하여 가중치가 가장 작은 간선부터 뽑음.
 * for 문에서 가중치가 큰 값을 넣게돼도 queue가 아닌 우선순위 큐 이므로 나중에 뽑혀나옴. (무시될 가능성이 큼)
 **/


public class Main {

    static StringBuilder sb;
    static List<int[]>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }
        result[K] = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            int weight = Integer.parseInt(st2.nextToken());
            arr[x].add(new int[] {y, weight});
        }



        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {K, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] > result[cur[0]]) continue;
            for (int i = 0; i < arr[cur[0]].size(); i++) {
                int[] next = arr[cur[0]].get(i);
                if (result[next[0]] > cur[1] + next[1]) {
                    result[next[0]] = cur[1] + next[1];
                    pq.add(new int[] {next[0], result[next[0]]});
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (result[i] != Integer.MAX_VALUE) {
                System.out.println(result[i]);
            }
            else {
                System.out.println("INF");
            }
        }
    }

}

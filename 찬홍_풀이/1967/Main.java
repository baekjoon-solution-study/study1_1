import java.io.*;
import java.util.*;

/**
 * 1967
 *
 * 트리의 지름을 구하려면 랜덤 노드에서 가장 먼 곳으로 dfs -> 도달한 노드에서 가장 먼 노드로 dfs 를 하면 최대 거리 구하기 가능.
 * 이거 모르고 dfs O(N^2) 돌림.
 * 그리고 N = 1 예외케이스 잘 따져봐야함.
 */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static List<List<int[]>> arr;
    static List<Integer> last_vertex;
    static boolean[] visited;
    static int result = 0;
    static int temp_vertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(x).add(new int[] {y, weight});
            arr.get(y).add(new int[] {x, weight});
        }

        last_vertex = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (arr.get(i).size() == 1) last_vertex.add(i);
        }

        visited[last_vertex.get(0)] = true;
        dfs(last_vertex.get(0), 0);

        result = 0;
        visited = new boolean[N + 1];

        visited[temp_vertex] = true;
        dfs(temp_vertex, 0);

        System.out.println(result);



    }
    static void dfs (int cur, int total_weight) {

        if (total_weight > result) {
            result = total_weight;
            temp_vertex = cur;
        }

        for (int[] i : arr.get(cur)) {
            if (!visited[i[0]]) {
                visited[i[0]] = true;
                dfs(i[0], total_weight + i[1]);
            }
        }
    }
}

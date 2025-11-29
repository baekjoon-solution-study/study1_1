import java.io.*;
import java.util.*;

/**
 * bfs, 이분탐색, 자료구조 이용한 문제
 *
 * bfs 시 정점이 1,000 이 넘어가면 메모리 터지니깐 반드시 ArrayList<int[]>[] 이용할 것
 * 다시 풀어볼 것
 */

public class Main {

    static ArrayList<Node>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        int max = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arr[x].add(new Node(y, z));
            arr[y].add(new Node(x, z));
            if (z > max) max = z;
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = max;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(first, end, mid)) {
                left = mid + 1;
                ans = mid;
            }
            else {
                right = mid - 1;
            }
            for (int i = 0; i < visited.length; i++) {
                visited[i] = false;
            }
        }
        System.out.println(ans);

    }
    static boolean possible(int first, int end, int mid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(first);
        visited[first] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Node node : arr[cur]) {
                if (!visited[node.to] && node.weight >= mid) {
                    if (node.to == end) return true;
                    queue.add(node.to);
                    visited[node.to] = true;
                }
            }
        }
        return false;
    }

    public static class Node {
        int to;
        int weight;
        Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    /*
    static int bfs(int first, int end, int idx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {idx, arr[first][idx]});
        visited[first] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int next = cur[0];
            if (next == end) return cur[1];
            int max = 0;
            int idx2 = 0;
            for (int i = 1; i < arr[next].length; i++) {
                if (!visited[i] && arr[next][i] != 0 && arr[next][i] > max) {
                    max = arr[next][i];
                    idx2 = i;
                }
            }
            if (max != 0) {
                queue.add(new int[] {next, idx2, Math.min(max, cur[1])});
                visited[idx2] = true;
            }

        }
        return -1;
    }

     */
}
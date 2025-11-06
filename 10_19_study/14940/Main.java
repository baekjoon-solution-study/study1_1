import java.io.*;
import java.util.*;

/**
 * 2시간 동안 dfs로 풀려다 못품. 힌트를 얻고 고민하다 2 -> 모든 노드 를 탐색하는게 훨씬 쉽다는걸 깨닫고
 * bfs로 바로 해결
 * 최단 거리면 bfs 부터 생각해야함.
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int [][] map;
    static int target_x;
    static int target_y;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st2.nextToken());
                map[i][j] = value;
                if (value == 2) {
                    target_x = i;
                    target_y = j;
                    map[i][j] = 0;
                }
                else if (value == 0) {
                    visited[i][j] = true;
                }
            }
        }
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{target_x,target_y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + move[i][0];
                int y = cur[1] + move[i][1];
                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (visited[x][y] == false) {
                        queue.add(new int[]{x, y});
                        map[x][y] = map[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false) {
                    map[i][j] = -1;
                }
            }
        }
        for (int[] i : map) {
            for (int j : i) {
                sb.append(j + " ");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
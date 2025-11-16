import java.io.*;
import java.util.*;

/**
 * ㅈㄴ어려움.
 * AI에게 힌트얻고 4, 5시간동안 겨우 품
 * DP에 대해 좀 알게됨
 * 복습 해야할 듯
 */

public class Main {

    static int[][] arr;
    static int[][] level;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        level = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs(N, M));


    }
    static int bfs(int max_x, int max_y) {
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int[] start = {0, 0};
        queue.add(start);
        level[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (visited[current[0]][current[1]]) continue;
            visited[current[0]][current[1]] = true;
            if (current[0] == max_x - 1 && current[1] == max_y - 1) break;

            for (int[] i : move) {
                int x = current[0] + i[0];
                int y = current[1] + i[1];
                if (0 <= x && x < max_x && 0 <= y && y < max_y) {
                    if (arr[x][y] == 1) {
                        queue.add(new int[]{x, y});
                        level[x][y] = level[current[0]][current[1]] + 1;
                    }
                }
            }
        }
        return level[max_x - 1][max_y - 1];

    }
}
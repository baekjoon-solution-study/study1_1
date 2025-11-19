import java.io.*;
import java.util.*;

/**
 * 7576
 * 3차원 bfs 문제.
 * 오히려 구현이 까다로웠음. 알고리즘 파악은 금방함.
 * 초기값에 여러개 넣는 형식도 있음을 알아야함.
 *
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][][] arr;
    static int[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        arr = new int[H][M][N];
        visited = new int [H][M][N];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[i][j][k] = Integer.parseInt(st1.nextToken());
                    if (arr[i][j][k] == 1) {
                        list.add(new int[] {j, k, i});  // bfs 초기 세팅에서 1로 시작하는 좌표를 전부 넣음
                    }
                }
            }
        }
        bfs(list, H, M, N);
        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (visited[i][j][k] > max) max = visited[i][j][k];
                }
            }
        }
        System.out.println(max);
    }

    static void bfs(List<int[]> list, int H, int M, int N) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i[] : list) {
            queue.add(i);
        }

        int[] move_x = {1, -1, 0, 0, 0, 0};
        int[] move_y = {0, 0, 1, -1, 0, 0};
        int[] move_z = {0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + move_x[i];
                int ny = y + move_y[i];
                int nz = z + move_z[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N && 0 <= nz && nz < H) {
                    if (arr[nz][nx][ny] != -1) {
                        if (arr[nz][nx][ny] == 0 && visited[nz][nx][ny] == 0) {  // 처음 방문
                            queue.add(new int[]{nx, ny, nz});
                            visited[nz][nx][ny] = visited[z][x][y] + 1;
                            arr[nz][nx][ny] = 2;
                        }
                    }
                }
            }
        }
    }

}
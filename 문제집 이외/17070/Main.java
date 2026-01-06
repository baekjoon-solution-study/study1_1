import java.io.*;
import java.util.*;

/**
 * 17070
 *
 * 초기에 BFS로 풀어서 해결했지만 시간 초과 발생할 가능성이 너무 높음. 그리고 if, else문이 많아짐.
 * 최단 거리가 아닌 최대 가짓 수를 구하는 문제이므로 DP가 최적.
 */

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N + 1][N + 1][3];
        dp[1][2][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 1) continue;
                dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];  // 가로 방향으로 온 경우
                dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];  // 세로 방향으로 온 경우
                if (arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];  // 대각선 방향으로 온 경우
                }

            }
        }
        int result = 0;
        for (int i : dp[N][N]) {
            result += i;
        }
        System.out.println(result);


        /* BFS 풀이 (잘못된 방법)
        int result = 0;
        int[][] move = new int[][] {{0, 1}, {1, 0}, {1, 1}}; // 오른쪽, 아래, 대각선

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 1, 0});  // x, y, 이전 이동값
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int prev_move = cur[2];
            if (cur_x == N - 1 && cur_y == N - 1) {
                result++;
                continue;
            }
            for (int i = 0; i < 3; i++) {
                int next_x = cur_x + move[i][0];
                int next_y = cur_y + move[i][1];

                if (i == 0 && next_x < N && next_y < N - 1 && arr[next_x][next_y] == 0) {
                    if (prev_move != 1) {
                        q.add(new int[] {next_x, next_y, 0});
                    }
                }
                else if (i == 0 && next_x == N - 1 && next_y == N - 1 && arr[next_x][next_y] == 0) {
                    if (prev_move != 1) {
                        q.add(new int[] {next_x, next_y, 0});
                    }
                }

                else if (i == 1 && next_x < N - 1 && next_y < N && arr[next_x][next_y] == 0) {
                    if (prev_move != 0) {
                        q.add(new int[] {next_x, next_y, 1});
                    }
                }
                else if (i == 1 && next_x == N - 1 && next_y == N - 1 && arr[next_x][next_y] == 0) {
                    if (prev_move != 0) {
                        q.add(new int[] {next_x, next_y, 1});
                    }
                }

                else if (i == 2 && next_x < N && next_y < N && arr[next_x][next_y] == 0) {
                    if (arr[next_x - 1][next_y] == 0 && arr[next_x][next_y - 1] == 0) {
                        q.add(new int[] {next_x, next_y, 2});
                    }
                }

            }
        }
        System.out.println(result);

         */
    }
}

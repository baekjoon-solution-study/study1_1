import java.io.*;
import java.util.*;

/**
 * 1520
 *
 * 실패함.
 * 처음에 2중 for문으로 풀이하다 문제발생. 아래에서 위로 올라가는 경우를 고려하지 못함.
 * dfs 를 이용하여 모든 경로를 탐색해야함. (아래에서 위로 올라가는 경우도 있으므로)
 * 이미 이동했던 경로는 패스하는 센스가 중요함. (도착지로 가는 경로, 막다른 길 경로를 따로 설정하여 중복 계산을 막음)
 * dp[][] 에서 -1 은 이동하지 않음, 0 은 막다른 길, 1은 도착지로 가는 경로
 *
**/

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] move = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};  // 동 서 북 남
    static int[][] arr;
    static int[][] dp;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(1, 1));

        /**
         * 처음에 2중 for문으로 풀다 망함.
         */
        /*for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/




        /*int[][][] dp = new int[N + 1][M + 1][4];
        dp[1][1][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + move[k][0];
                    int ny = j + move[k][1];
                    if (1 <= nx && nx <= N && 1 <= ny && ny <= M) {
                        if (arr[i][j] > arr[nx][ny]) {  // 범위 안에 들고 이전 값보다 작은 경우
                            int temp = 0;
                            for (int a = 0; a < 4; a++) {
                                temp += dp[i][j][a];
                            }
                            dp[nx][ny][k] += temp;
                        }
                    }
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                int a = 0;
                for (int k = 0; k < 4; k++) {
                    if (i == 3 && j == 4) {
                        System.out.println(dp[i][j][k]);
                    }
                    a += dp[i][j][k];
                }
                //System.out.print(a + " ");
            }
            //System.out.println();
        }*/
    }
    static int dfs(int x, int y) {
        if (x == N && y == M) return 1;  // 도착하면 1

        if (dp[x][y] != -1) {  // -1 이 아니라면 0 or 양수 (즉, 도착 or 막다른 길)
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if (1 <= nx && nx <= N && 1 <= ny && ny <= M){
                if (arr[x][y] > arr[nx][ny]) {
                    dp[x][y] += dfs(nx, ny);  // 4방향 전부 더해줘야 하므로 += 을 이용
                }
            }
        }
        return dp[x][y];
    }
}

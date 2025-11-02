import java.io.*;
import java.util.StringTokenizer;

/**
 * 모든 경로를 탐색해야하므로 재귀를 이용해 전부 탐색합니다.
 */

public class Main {

    static int[][] move = {{1, -1}, {1, 0}, {1, 1}};
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            tour(0, i, 0, -1);
        }


        System.out.println(min);
    }
    public static void tour(int n, int m, int sum, int last) {
        int next = sum + arr[n][m];
        //System.out.println(n + " " + m + " " + next + " " + last);
        if (n == arr.length - 1) {
            if (min > next) {
                min = next;
            }
            return;
        }
        for (int i = 0; i < move.length; i++) {
            if (i == last) continue;  // 이전에 움직인 경로로 불가능
            int y = m + move[i][1];
            if (0 <= y && y < arr[0].length) {
                tour(n + move[i][0], y, next, i);
            }
        }

    }

}
import java.io.*;
import java.util.*;

/**
 * 14499
 *
 * 시물레이션/구현 문제
 * 3차원 주사위로 생각하니 너무 복잡해서 못풀겠어서 1차원 평면으로 펼치고 좌/우/위/아래 로 돌리면 평면의 인덱스가 어디로 움직이는지
 * 손으로 직접 그려서 매핑시킴.
 * 이런 문제는 직접 손으로 그려야 함.
 */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] dice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int[][] move = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 동 서 북 남
        int[][] arr = new int[N][M];
        dice = new int[7];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int direct;
        for (int i = 0; i < num; i++) {
            direct = Integer.parseInt(st.nextToken()) - 1;
            int nx = x + move[direct][0];
            int ny = y + move[direct][1];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                roll(direct);
                if (arr[nx][ny] != 0) {
                    dice[6] = arr[nx][ny];
                    arr[nx][ny] = 0;
                }
                else {
                    arr[nx][ny] = dice[6];
                }
                x = nx;
                y = ny;
                sb.append(dice[1]).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void roll(int direct) {
        int top = dice[1];
        int left = dice[4];
        int right = dice[3];
        int up = dice[2];
        int down = dice[5];
        int bottom = dice[6];
        switch (direct) {
            case 0 :
                dice[1] = left;
                dice[2] = up;
                dice[3] = top;
                dice[4] = bottom;
                dice[5] = down;
                dice[6] = right;
                break;

            case 1 :
                dice[1] = right;
                dice[2] = up;
                dice[3] = bottom;
                dice[4] = top;
                dice[5] = down;
                dice[6] = left;
                break;

            case 2 :
                dice[1] = down;
                dice[2] = top;
                dice[3] = right;
                dice[4] = left;
                dice[5] = bottom;
                dice[6] = up;
                break;

            case 3 :
                dice[1] = up;
                dice[2] = bottom;
                dice[3] = right;
                dice[4] = left;
                dice[5] = top;
                dice[6] = down;
                break;

        }
    }
}

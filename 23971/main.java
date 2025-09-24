import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 생각 흐름
 * 1. boolean seat[][] 에 본인 포함 띄어야 하는 범위를 전부 true로 설정하며 반복
 * -> 문제점 : 한명 실행마다 (0, 0)으로 돌아와서 실행해야함. ㅈㄴ비효율
 *
 * 2. 수학적 계산이 가능할 것 같음
 * 띄어야 하는 거리 + 본인자리(1) 이므로 전체에 이 값을 나눈다. 그리고 나머지가 있을 경우 1명은 더 앉기 가능하므로 1을 더함
 * 이걸 가로 세로 모두 하고 곱하면 끝
 *
 * 이걸 30분이나 걸리는 레전드
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = maxSeat(H, W, N, M);
        System.out.println(result);
    }

    public static int maxSeat(int H, int W, int N, int M) {
        int row = N + 1;
        int col = M + 1;

        int total_row = H / row + (H % row == 0 ? 0 : 1);
        int total_cal = W / col + (W % col == 0 ? 0 : 1);
        //System.out.println(total_row + " " + total_cal);
        return total_row * total_cal;
    }
}
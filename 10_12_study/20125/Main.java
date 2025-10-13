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
        int N = Integer.parseInt(br.readLine());

        String[][] cookies = new String[N][N];
        boolean isHead = false;
        int[] head = new int[2];
        int[] heart = new int[2];
        int body = 0;
        int leftArm = 0;
        int rightArm = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] st = line.split("");
            for (int j = 0; j < N; j++) {
                cookies[i][j] = st[j];
                if (isHead == false && cookies[i][j].equals("*")) {
                    isHead = true;
                    head[0] = i + 1;
                    head[1] = j + 1;
                    heart[0] = head[0] + 1;
                    heart[1] = head[1];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int y = heart[0] - 1;
            if (i == heart[1] - 1) continue;
            if (i < heart[1] - 1 && cookies[y][i].equals("*")) {
                leftArm++;
            }
            if (i > heart[1] - 1 && cookies[y][i].equals("*")) {
                rightArm++;
            }

        }
        for (int i = heart[0]; i < N; i++) {
            if (cookies[i][heart[1] - 1].equals("*")) {
                body++;
            }
            else break;
        }

        for (int i = heart[0] + body; i < N; i++) {
            if (cookies[i][heart[1] - 2].equals("*")) leftLeg++;
            if (cookies[i][heart[1]].equals("*")) rightLeg++;
        }
        System.out.println(heart[0] + " " + heart[1]);
        System.out.println(leftArm + " " + rightArm + " " + body + " " + leftLeg + " " + rightLeg);
    }

}
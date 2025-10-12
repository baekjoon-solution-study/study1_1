import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] switches;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer line = new StringTokenizer(br.readLine());
        switches = new boolean[N];
        for (int i = 0; i < N; i++) {
            String str = line.nextToken();
            switches[i] = str.equals("1");
        }
        int M = Integer.parseInt(br.readLine());
        int[][] chance =  new int[M][2];  // 0 -> 성별, 1 -> 번호

        for (int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            chance[i][0] = Integer.parseInt(str.nextToken());
            chance[i][1] = Integer.parseInt(str.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int sex =  chance[i][0];
            int num = chance[i][1];

            if (sex == 1) {  // 남자인 경우
                for (int j = num; j <= N; j += num) {
                    toggle(j - 1);
                }
            }
            else {
                toggle(num - 1);  // 여자인 경우, 선택 받은 수 먼저 변경
                int left = num - 2;
                int right = num;
                while (left >= 0 && right < N) {
                    if (switches[left] == switches[right]) {
                        toggle(left--);
                        toggle(right++);
                    }
                    else break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (switches[i]) sb.append("1");
            else sb.append("0");
            if ((i + 1) % 20 == 0) {
                sb.append("\n");
                continue;
            }
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString());
    }
    public static void toggle (int idx) {
        if (switches[idx] == true) {
            switches[idx] = false;
        }
        else {
            switches[idx] = true;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 8979(올림픽) 문제와 똑같음. 여러 값을 비교해서 등수를 매길 경우 굳이 정렬하지 않고 가능함.
 * 나보다 아래인 비교군은 신경안씀. 오로지 나보다 모든면에서 큰 값에만 rank++, 둘 중 하나만 크다면 나랑 등수가 같으므로 pass
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] ranking = new int[N];
        for (int i = 0; i < N; i++) {
            int rank = 1;
            int[] temp = people[i];
            for (int j = 0; j < N; j++) {
                if (temp == people[j]) continue;
                if (temp[0] < people[j][0] && temp[1] < people[j][1]) rank++;
            }
            ranking[i] = rank;
        }
        for (int i : ranking) {
            System.out.println(i);
        }
    }
}
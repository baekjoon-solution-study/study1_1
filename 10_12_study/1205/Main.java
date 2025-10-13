import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1205 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int myScore = Integer.parseInt(st.nextToken());
        int rankingIn = Integer.parseInt(st.nextToken());
        int[] scores = new int[N];

        if (N > 0) {

            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(line.nextToken());
            }

            int rank = 1;
            int duplicate = 0;
            for (int score : scores) {
                if (score > myScore) {
                    rank++;
                }
                else if (score == myScore) {
                    duplicate++;
                }
            }
            if (rank > rankingIn) {
                System.out.println(-1);
            }
            else if (rank + duplicate > rankingIn) {
                System.out.println(-1);
            }
            else {
                System.out.println(rank);
            }
        }
        else System.out.println(1);
    }
}

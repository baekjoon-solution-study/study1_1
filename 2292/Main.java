import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1 -> 2 ~ 7 -> 8 ~ 19 -> 20 ~ 37 -> 38 -> 61 -> 62 ... (6, 12, 18, 24... 6개 씩 증가함)
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int size = 6;
        int count = 1;
        int start = 2;


        while (start <= N) {
            start += count * size;
            count++;
        }
        if (N == 1) {
            System.out.println(1);
        }
        else {
            System.out.println(count);
        }
    }
}
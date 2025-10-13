import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
 * 1. 이중 for문으로 더하다가 시간초과 발생
 * 2. 맨 앞과 맨 뒤의 값을 더하고 빼며 for문을 없앰.
 */
public class Test21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int max = 0;
        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (i > X - 1) {
                sum -= arr[i - X];
                if (sum > max) {
                    max = sum;
                    count = 1;
                }
                else if (sum == max) count++;
            }
            if (i == X - 1) {
                max = sum;
            }
        }

        if (max == 0) {
            bw.write("SAD");
        }
        else {
            bw.write(String.valueOf(max));
            bw.newLine();
            bw.write(String.valueOf(count));
        }
        bw.flush();

    }

}

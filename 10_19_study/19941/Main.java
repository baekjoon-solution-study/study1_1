import java.io.*;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘인데 그리디가 아닌거같음. 그냥 구현으로 풀리는데
 * k 가 10 보다 작거나 같다는 조건때문에 구현으로 해결됨. 만약 k 도 20000까지 가능했다면 이 방법은 안될듯
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        char[] arr = line.toCharArray();
        int count = 0;
        for (int i = 0; i < N; i++) {
            char c = arr[i];
            if (c == 'P') {
                int start = Math.max(0, i - K);
                int end = Math.min(N - 1, i + K);
                for (int j = start; j <= end; j++) {
                    if (arr[j] == 'H') {
                        arr[j] = '0';
                        count++;
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();

    }

}
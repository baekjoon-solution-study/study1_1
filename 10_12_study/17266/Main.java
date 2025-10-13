import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //static boolean[] isLight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalRoad = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] lamp = new int[N];
        //isLight = new boolean[totalRoad + 1];
        for (int i = 0; i < N; i++) {
            lamp[i] = Integer.parseInt(st.nextToken());
        }
        /*
        int result = 1;

        while(true) {
            for (int i = 0; i < N; i++) {
                int x = lamp[i];
                int start = Math.max((x - result), 0);
                int end = Math.min((x + result), totalRoad);
                for (int j = start; j <= end; j++) {
                    isLight[j] = true;
                }
            }
            if (isAllTrue()) {
                break;
            } else result++;
        }
         */
        int max = Math.max(lamp[0], totalRoad - lamp[N - 1]);
        for (int i = 0; i < N - 1;  i++) {
            int first = lamp[i];
            int second = lamp[i + 1];
            int length = 0;
            if ((second - first) % 2 == 0) {
                length = (second - first) / 2;
            }
            else {
                length = (second - first) / 2 + 1;
            }
            if (length > max) max = length;
        }
        System.out.println(max);

    }
    /*
    public static boolean isAllTrue() {
        for (int i = 0; i < isLight.length; i++) {
            if (!isLight[i]) {
                return false;
            }
        }
        return true;
    }
    */
}

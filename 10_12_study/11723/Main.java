import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 더 최적화 시키는 경우는 비트 연산이 있던데 그건 오버같음. 굳이 공부할 필요는 못느끼겠다.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int limit = 20;
        boolean[] list = new boolean[limit + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String command = st.nextToken();
            int num = (st.hasMoreTokens()) ? Integer.parseInt(st.nextToken()) : -1;
            switch (command) {
                case "add" :  {
                    boolean isContain = list[num];
                    if (isContain == false) {
                        list[num] = true;
                    }
                    break;
                }

                case "remove" : {
                    boolean isContain = list[num];
                    if (isContain == true) {
                        list[num] = false;
                    }
                    break;
                }

                case "check" :  {
                    boolean isContain = list[num];
                    String str = (isContain == true) ? "1" : "0";
                    sb.append(str).append("\n");
                    break;
                }
                case "toggle" : {
                    boolean isContain = list[num];
                    list[num] = isContain != true;
                    break;
                }

                case "all" : {
                    for (int j = 1; j <= limit; j++) {
                        list[j] = true;
                    }
                    break;
                }

                case "empty" : {
                    for (int j = 1; j <= limit; j++) {
                        list[j] = false;
                    }
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
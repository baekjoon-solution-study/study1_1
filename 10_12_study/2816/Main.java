import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 문제가 좀 이상함. -> 하나의 예시에 정답이 너무 많음.
 */
public class Main {

    static String[] names;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chanel = Integer.parseInt(br.readLine());

        names = new String[chanel];

        for (int i = 0; i < chanel; i++) {
            names[i] = br.readLine();
        }
        setting("KBS1", 0);
        setting("KBS2", 1);
        System.out.println(sb.toString());

    }

    public static void setting(String chanel, int spot) {

        int idx = 0;
        /**
         * chanel index를 찾기
         */
        while (true) {

            /*
            if (names[idx + 1].equals("KBS2") || names[idx + 1].equals("KBS1")) {  // 3번 실행
                String temp = names[idx];
                names[idx] = names[idx + 1];
                names[idx + 1] = temp;
                sb.append("3");
                if (names[idx].equals(chanel)) {
                    break;
                }
            }
            else {
                sb.append("1");
            }
            idx++;

             */

            if (names[idx].equals(chanel)) {
                break;
            }
            idx++;
            sb.append("1");


        }

        while (idx > 0) {
            String temp = names[idx];
            names[idx] = names[idx - 1];
            names[idx - 1] = temp;
            idx--;
            sb.append("4");

            if (spot == idx) {
                break;
            }
        }
    }
}
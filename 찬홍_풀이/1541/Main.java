import java.io.*;
import java.util.*;

/**
 * 1514
 *
 * Greedy 조건은 20분 걸려서 찾았지만 문자열 파싱 부분에서 최악임.
 * split 을 이용해서 풀 수 있었다.
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line =  br.readLine();
        /*
        char[] arr = line.toCharArray();

        int result = 0;
        int temp = 0;

        boolean first = true;
        for (int i = 0; i < arr.length; i++) {  // -1 + 2 + 3 - 4, 1+2-3+4+5-6-7
            if (arr[i] == '-' && first) {
                temp += Integer.parseInt(sb.toString());
                sb.setLength(0);
                result += temp;
                temp = 0;
                first = false;
            }
            else if ('0' <= arr[i] && arr[i] <= '9') {
                sb.append(arr[i]);
            }
            else if (arr[i] == '-' || arr[i] == '+') { //  1+2+3+4-5
                temp += Integer.parseInt(sb.toString());
                sb.setLength(0);
            }
            //System.out.println(result + " " + temp);
        }
        temp += Integer.parseInt(sb.toString());
        if (first) {
            result += temp;
        }
        else {
            result -= temp;
        }

        System.out.println(result);

         */


        /**
         * '+', '-' 가 주기적으로 나오고 연산자만 뺀 숫자 집합을 알고싶다면 split 을 사용할 생각을 해야...
         */
        int result = 0;
        String[] tokens = line.split("-");

        for (int i = 0; i < tokens.length; i++) {
            int temp = 0;

            String[] nums = tokens[i].split("\\+");
            for (String num : nums) {
                temp += Integer.parseInt(num);
            }

            if (i == 0) result += temp;
            else result -= temp;
        }
        System.out.println(result);
    }
}
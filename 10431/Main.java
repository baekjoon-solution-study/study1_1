import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 버블 정렬로 해결함. -> 버블 정렬보다 선택 정렬을 이용하면 리소스를 아낄 수 있다.
 * 2. 정렬할 요소를 temp로 지정하고 매번 넣는게 아닌 배열의 요소를 한칸씩 밀어내고 마지막에 넣는다.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int limit = 20;

        for (int i = 0; i < N; i++) {
            int[] students = new int[limit];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startNumber = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int j = 0; j < limit; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < limit; j++) {
                int start = j - 1;
                int temp = students[j];
                while (start >= 0 && students[start] > temp) {
                    students[start + 1] = students[start];
                    start--;
                    count++;
                }
                students[start + 1] = temp;
            }
            /* 비효율 코드

            for (int j = 1; j < limit; j++) {
                int start = j;
                while (start >= 1) {
                    if (students[start - 1] > students[start]) {
                        int temp = students[start - 1];
                        students[start - 1] = students[start];
                        students[start] = temp;
                        start--;
                        count++;

                    } else break;
                }
            }
             */
            sb.append(startNumber).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
import java.io.*;
import java.util.*;

/**
 * 1874
 *
 * 이 문제 반드시 다시 풀어볼 것
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 1 2 3 4
        // 1 2
        // 1 2 5 6
        // 1 2 5
        // 1 2 5 7 8

        Stack<Integer> stack = new Stack<>();
        int start = Integer.parseInt(br.readLine());
        for (int i = 1; i <= start; i++) {
            stack.push(i);
            sb.append("+").append("\n");
        }
        stack.pop();
        sb.append("-").append("\n");

        int prev = start;
        for (int i = 0; i < N - 1; i++) {
            int num = Integer.parseInt(br.readLine());
            if (stack.isEmpty() || stack.peek() < num) {
                for (int j = prev + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                prev = Math.max(prev, num);
            }

            if (stack.isEmpty()) {
                System.out.println("NO");
                return;
            }
            else if (stack.peek() == num) {
                sb.append("-").append("\n");
                stack.pop();
            }
            else {
                System.out.println("NO");
                return;
            }

        }
        bw.write(sb.toString());
        bw.flush();

    }
}
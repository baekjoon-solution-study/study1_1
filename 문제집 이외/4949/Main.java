import java.io.*;
import java.util.*;

/**
 * 4949
 * stack 공부용
 * if case를 복잡하게 말고 필요한 조건만 만들 필요가 있음
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            if (line.equals(".")) break;

            char[] arr = line.toCharArray();
            boolean flag = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(' || arr[i] == '[') {
                    stack.push(arr[i]);
                }
                else if (arr[i] == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
                else if (arr[i] == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }

            }

            if (flag && stack.isEmpty()) {
                sb.append("yes").append('\n');
            }
            else {
                sb.append("no").append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
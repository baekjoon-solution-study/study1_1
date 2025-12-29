import java.io.*;
import java.util.*;

/**
 * 5430
 *
 * 문자열 파싱 문제 + Deque 사용
 * 예외 조건을 못찾아 오래걸림.
 **/


public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            int M = Integer.parseInt(br.readLine());
            String string_arr = br.readLine();
            String temp = string_arr.substring(1, string_arr.length() - 1);
            String[] split = temp.split(",");
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < M; j++) {
                deque.addLast(Integer.parseInt(split[j].trim()));
            }

            int cnt = 0;
            boolean flag = true;
            for (int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);

                switch (c) {
                    case 'D' : {
                        if (!deque.isEmpty()) {
                            if (cnt % 2 == 0) {
                                deque.pollFirst();
                            }
                            else {
                                deque.pollLast();
                            }
                        }
                        else {
                            flag = false;
                            break;
                        }
                        break;
                    }

                    case 'R' : {
                        cnt++;
                    }
                }
                if (!flag) break;
            }

            List<Integer> list = new ArrayList<>();
            if (cnt % 2 == 1) {
                while(!deque.isEmpty()) {
                    list.add(deque.pollLast());
                }
            }
            else {
                while(!deque.isEmpty()) {
                    list.add(deque.pollFirst());
                }
            }

            if (flag) {
                sb.append("[");
                for (int j : list) {
                    sb.append(j).append(",");
                }
                if (!list.isEmpty()) {
                    sb.delete(sb.length() - 1, sb.length());
                }
                sb.append("]");
            }
            else {
                sb.append("error");
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

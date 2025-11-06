import java.io.*;
import java.util.*;

/**
 * 2시간 동안 고민한게 아까울 정도로 갑자기 해결책이 떠올라 바로 해결함.
 * 이전엔 배열에 1 ~ N 까지 미리 넣어두고 sort 했는데 그냥 전부 0 인 배열에 하나씩 넣는게 훨씬 쉬운듯.
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int len = Integer.parseInt(st.nextToken());
            if (i == 1) {
                arr[len] = i;
                continue;
            }

            int count = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] == 0) {
                    if (count != len) {
                        count++;
                    }
                    else {
                        arr[j] = i;
                        break;
                    }
                }
            }
        }
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length()-1, sb.length());
        }
        bw.write(sb.toString());
        bw.flush();
        // 1 2 3 4
        // 3 2 1 4
        //
        // 4 2 1 3

        // 1 2 3 4 5 6 7
        // 7 2 3 4 5 6 1
        // 7 2 3 4 6 5 1
        //

        // 1 2 3 4 5 6
        // 6 2 3 4 5 1
        // 6 3 4 5 2 1
        // 6 4 5 3 2 1
        // 6 5 4 3 2 1
    }


}
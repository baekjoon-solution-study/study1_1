import java.io.*;
import java.util.*;

/**
 * dfs로 풀어야하는건 알았는데 중복제거를 처리 못했음.
 * 약간의 힌트를 받아서 visited[] 로 지나간 곳을 true 로 바꾸고 다 사용하면 false 로 반납하며 해결
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        combination(N, M, 0, "");
        bw.write(sb.toString());
        bw.flush();
    }
    static void combination(int N, int M, int depth, String line) {

        if (depth == M)  {
            sb.append(line.trim()).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            int next = depth + 1;
            if (visited[i] == false) {
                visited[i] = true;
                combination(N, M, next,line + " " + (i + 1));
                visited[i] = false;
            }

        }

    }

}
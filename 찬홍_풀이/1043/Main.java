import java.io.*;
import java.util.*;

/**
 * 1043
 *
 * BFS 로 풀었지만 'UNION FIND`를 이용하면 효율적 풀이가 가능.
 */

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] edges = new int[N + 1][N + 1];
        List<List<Integer>> group = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            group.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int true_num = Integer.parseInt(st.nextToken());
        int[] true_arr = new int[true_num];
        if (true_num != 0) {
            for (int i = 0; i < true_num; i++) {
                true_arr[i] = Integer.parseInt(st.nextToken());
            }
            if (true_num != 1) {
                for (int i = 0; i < true_num - 1; i++) {  // 진실은 아는 정점끼리 간선 생성
                    edges[true_arr[i]][true_arr[i + 1]] = 1;
                    edges[true_arr[i + 1]][true_arr[i]] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num != 1) {  // 그룹이 2명 이상인 경우
                int[] temp = new int[num];
                for (int j = 0; j < num; j++) {
                    temp[j] = Integer.parseInt(st.nextToken());
                    group.get(i).add(temp[j]);  // 그룹을 저장
                }
                for (int j = 0; j < num - 1; j++) { // 간선 생성
                    edges[temp[j]][temp[j + 1]] = 1;
                    edges[temp[j + 1]][temp[j]] = 1;
                }
            }
            else {
                group.get(i).add(Integer.parseInt(st.nextToken()));  // 그룹에 1명있을 경우
            }
        }

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < true_arr.length; i++) {
            visited[true_arr[i]] = true;
            q.add(true_arr[i]);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && edges[cur][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        int result = 0;
        for (List<Integer> list : group) {
            boolean flag = true;
            for (int i : list) {
                if (visited[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) result++;
        }
        System.out.println(result);


    }
}

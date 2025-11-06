import java.io.*;
import java.util.*;

/**
 * 예전에 풀었던 문제라 금방 해결함.
 */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static boolean[][] edges;
    static Queue<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[vertexNum];
        edges = new boolean[vertexNum][vertexNum];

        for (int i = 0; i < edgeNum; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st1.nextToken());
            int endNode = Integer.parseInt(st1.nextToken());
            edges[startNode - 1][endNode - 1] = true;
            edges[endNode - 1][startNode - 1] = true;
        }

        dfs(start - 1);
        sb.delete(sb.length() - 1, sb.length());
        sb.append('\n');
        bw.write(sb.toString());

        visited = new boolean[vertexNum];
        sb = new StringBuilder();

        bfs(start - 1);
        sb.delete(sb.length() - 1, sb.length());
        bw.write(sb.toString());
        bw.flush();

    }
    static void dfs(int start) {

        if (visited[start] == true) return;
        visited[start] = true;
        sb.append(start + 1).append(" ");

        for (int i = 0; i < edges.length; i++) {
            if (edges[start][i] == true && visited[i] == false)  {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        list.add(start);

        while (list.isEmpty() == false) {
            int node = list.poll();
            if (visited[node] == true) continue;
            visited[node] = true;
            sb.append(node + 1).append(" ");
            for (int i = 0; i < edges.length; i++) {
                if (edges[node][i] == true && visited[i] == false) {
                    list.add(i);
                }
            }
        }

    }



}
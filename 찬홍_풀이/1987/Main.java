import java.io.*;
import java.util.*;

/**
 * 1987
 *
 * 초기 설계는 BFS 였으나 큐에 문자열을 담게되면 무조건 메모리 터짐.
 * 백트레킹을 이용하고 문자열은 배열 1개로 이용하면 메모리 초과 발생 안함.
 * 또한, set을 이용해서 통과는 했지만 시간이 너무 오래걸림. (contains, add, remove)에서 오래걸림.
 * 어차피 문자열 26개이므로 visited[] 를 이용하면 훨씬 빠름.
 *
 * 추가로 max()를 이용해 최대 개수를 세고있었는데 재귀가 100만번 발생할 경우 100만 * 26 의 계산을 해서 오래걸림.
 * 재귀에 count 변수를 추가하여 max()를 제거함.
 */

public class Main {

    static StringBuilder sb;
    static int N;
    static int M;
    static int[][] arr;
    static boolean[] visited;
    static int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - 'A';
            }
        }
        visited = new boolean[26];
        visited[arr[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(result);

    }
    static void dfs (int x, int y, int count) {

        if (count > result) {
            result = count;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[arr[nx][ny]]) {
                visited[arr[nx][ny]] = true;
                dfs(nx, ny, count + 1);
                visited[arr[nx][ny]] = false;
            }
        }
    }
}

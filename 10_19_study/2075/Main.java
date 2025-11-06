import java.io.*;
import java.util.*;

/**
 * 실수로 우선순위 큐인거 봐버렸음. 그래도 메모리, 시간을 보니 일반적인 방법으로 못풀것 같아서 다른 생각을 함.
 * 최근 문제에서 최대 힙 구현 문제가 나와서 그거 생각하니 바로 될 것 같음.
 * 두 가지로 통과했는데 입력을 배열에 다 받고 정렬된 순서로 queue에 넣는게 조금 더 빠름.
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        //int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }
        /*
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                queue.add(arr[j][i]);
            }
        }

         */

        for (int i = 0; i < N - 1; i++) {
            queue.remove();
        }
        bw.write(String.valueOf(queue.poll()));
        bw.flush();

    }


}
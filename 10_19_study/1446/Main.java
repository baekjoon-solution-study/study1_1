import java.io.*;
import java.util.*;

/**
 * 2시간 걸려 겨우 해결.
 * 찾아보니 투포인터 문제였는데 거의 비슷하게 품.
 * 문제는 K 값을 넘어설 때 포인터의 위치를 찾는 과정에서 counter 값을 안빼고 있어서 특정 테케에 틀릴 수 있다함;
 * while 문으로 한칸씩 옮기며 counter 도 빼는게 일반적
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        ArrayList<int[]> list = new ArrayList<>();
        int[] route = new int[total + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (cost > end - start) continue;
            if (end > total) continue;
            list.add(new int[]{start, end, cost});
        }
        list.sort((o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i <= total; i++) {
            if (i > 0) {
                if (route[i] == 0 || route[i] > route[i - 1] + 1) {
                    route[i] = route[i - 1] + 1;
                }
            }

            for (int j = 0; j < list.size(); j++) {
                int[] route1 = list.get(j);
                int start = route1[0];
                int end = route1[1];
                int cost = route1[2];
                if (start == i) {
                    if (route[end] == 0 || route[end] > route[start] + cost) {
                        route[end] = route[start] + cost;
                    }
                }
            }
        }
        System.out.println(route[total]);
    }

}
import java.io.*;
import java.util.*;

/**
 * 1931
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.add(new int[]{first, second});
        }

        /**
         * 정렬할 때 끝나는 시간이 빠를 순으로 먼저 넣으면 된다.
         * 잘못 정렬한 부분은 끝나는 시간이 같을 경우 시간이 짧은 회의를 먼저 넣었는데
         * 이렇게 되면 '시작시간 == 끝나는 시간' 인 경우 처리가 복잡해짐.
         * 시작시간이 빠른 순으로 정렬해주면 간단해짐.
         * -> 이렇게 해도 항상 최대 회의 수를 만들 수 있음.
         */
        // before
        list.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }
            return o1[1] - o2[1];
        });
        // after
        list.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        if (list.size() > 0) {
            int current_first = list.get(0)[0];
            int current_last = list.get(0)[1];
            int current = current_last;
            count++;

            for (int i = 1; i < list.size(); i++) {
                int first = list.get(i)[0];
                int last = list.get(i)[1];

                if (first >= current) {
                    current = last;
                    count++;
                }
                else if (current_last == current_first && last <= current) {
                    count++;
                }
                current_first = first;
                current_last = last;
            }
        }
        System.out.println(count);
    }

}
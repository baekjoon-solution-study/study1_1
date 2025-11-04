import java.io.*;
import java.util.*;

/**
 * 어찌저찌 해결은 했지만 레거시 코드라 좀 의미없음.
 * 새로운 해결책 찾아보니 왼쪽 -> 중앙, 중앙 -> 오른쪽 은 방향만 반대로 탐색하면 같은 로직이였음.
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr[i][0] = M;
            arr[i][1] = K;
            if (K > max) max = M;
        }
        int[][] sort = Arrays.stream(arr).sorted((o1, o2) -> o1[0] - o2[0]).toArray(int[][]::new);
        int x = sort[0][0];
        int y = sort[0][1];
        int result = y;
        int idx = 0;
        for (int i = 1; i < N; i++) {
            if (y == max) {
                idx = i;
                break;
            }
            if (sort[i][1] >= y) {
                result += (sort[i][0] - x - 1) * y;
                result += sort[i][1];
                x = sort[i][0];
                y = sort[i][1];
            }
        }
        //System.out.println(result);
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = idx; i < N; i++) {
            list.add(sort[i]);
        }
        list.sort((o1, o2) -> o2[1] - o1[1]);  // 하행 시 내림차순 정렬

        for (int j = 0; j < list.size(); j++) {
            int[] temp = list.get(j);
            if (temp[0] > x) {
                result += (temp[0] - x) * temp[1];
                x = temp[0];
            }
            if (x == sort[sort.length - 1][0]) break;  // 마지막 도달 시 끝
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();

         */

        /**
         * 왼쪽에서 중앙과 오른쪽에서 중앙으로 가는 로직이 똑같음.
         * 즉 왼쪽 -> 중앙은 정방향 순회하고 오른쪽 -> 중앙은 역방향 순회하며 넓이를 구하면
         * 두 로직이 같으며 해결 가능함.
         */
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int maxLength = 0;
        int maxIdx = 0;
        int area = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr[i][0] = M;
            arr[i][1] = K;
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < N; i++) {
            if (maxLength < arr[i][1]) {
                maxLength = arr[i][1];
                maxIdx = i;
            }
        }
        int currentLength = arr[0][1];
        int currentIdx = arr[0][0];
        for (int i = 1; i <= maxIdx; i++) {
            area += (arr[i][0] - currentIdx) * currentLength;
            currentIdx = arr[i][0];
            if (arr[i][1] > currentLength) {
                currentLength = arr[i][1];
            }
        }

        currentLength = arr[arr.length - 1][1];
        currentIdx = arr[arr.length - 1][0];
        for (int i = N - 2; i >= maxIdx; i--) {
            area += (currentIdx - arr[i][0]) * currentLength;
            currentIdx = arr[i][0];
            if (arr[i][1] > currentLength) {
                currentLength = arr[i][1];
            }
        }
        area += maxLength;
        sb.append(area);
        bw.write(sb.toString());
        bw.flush();
    }

}
//2 5 8 6 1
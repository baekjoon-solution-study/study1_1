import java.io.*;
import java.util.*;

/**
 * 첫 번째 시도에서 String[10^9] 만들어서 풀다가 메모리 초과뜸.
 * 범위 안의 조건을 구현하지 못해 질문계시판 찾아보니 이진탐색 사용하길래 바로 해결함.
 * 10^9 같이 말도 안되는 값이면 O(N) 으로 시도하면 안될듯.
 * 충분히 이분탐색으로 가능함.
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int before = -1;
        List<String> ranks = new ArrayList<>();
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            String name = st1.nextToken();
            int power = Integer.parseInt(st1.nextToken());
            if (before != power) {
                ranks.add(name);
                powers.add(power);
                before = power;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            int low = 0;
            int high = powers.size() - 1;
            int mid = 0;
            while (low <= high) {
                mid = (low + high) / 2;
                if (mid > 0) {
                    if (powers.get(mid) >= power && powers.get(mid - 1) < power) {
                        break;
                    }
                }
                else if (powers.get(mid) >= power) {
                    break;
                }

                if (powers.get(mid) < power) {
                    low = mid + 1;
                }
                else if (powers.get(mid) > power) {
                    high = mid - 1;
                }
            }
            sb.append(ranks.get(mid)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
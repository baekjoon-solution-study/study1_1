import java.io.*;
import java.util.*;

/**
 * 정렬 + 이분탐색으로 겨우 통과했는데 set 자료형이 있었음.
 * set 의 contain() 을 통해 존재 여부를 시간복잡도 1 로 찾을 수 있으므로 정렬과 이분탐색을 할 필요가 없어짐
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }
        boolean[] test = new boolean[words.size()];
        words.sort((o1, o2) -> o1.compareTo(o2));

        int count = 0;

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] temp  = line.split(",");
            for (int j = 0; j < temp.length; j++) {
                int low = 0;
                int high = words.size() - 1;
                int mid = 0;

                while (low <= high) {

                    mid = (low + high) / 2;
                    if (words.get(mid).equals(temp[j])) break;
                    if (words.get(mid).compareTo(temp[j]) < 0) {
                        low = mid + 1;
                    }
                    else {
                        high = mid - 1;
                    }
                }
                if (words.get(mid).equals(temp[j]) && test[mid] == false) {
                    test[mid] = true;
                    count++;
                }
            }
            sb.append(words.size() - count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
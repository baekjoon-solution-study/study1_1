import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 빈도수는 Map으로 count 후 sort에 람다식을 이용하여 1순위로 빈도수를 체크하도록 함.
 */
public class Test20920 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            if (temp.length() >= length && map.containsKey(temp) == false) {
                list.add(temp);
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        list.sort((o1, o2) -> {
            int o1_size = map.get(o1);
            int o2_size = map.get(o2);

            if (o1_size == o2_size) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                else {
                    return o2.length() - o1.length();
                }
            }
            else {
                return o2_size - o1_size;
            }

        });

        for (String a : list) {
            bw.write(a);
            bw.newLine();
        }
        bw.flush();


    }

}

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 문제 유형에 그리디라 있던데 이걸 그리디라 할 수 있나? 규칙 찾아서 바로 해결하긴 했는데
 * 별거 없노
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int count_0 = 0;
        int count_1 = 0;
        int remove_0 = 0;
        int remove_1 = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '1') {
                count_1++;
            }
            else {
                count_0++;
            }
        }


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '1') {
                if (remove_1 < count_1 / 2) {
                    remove_1++;
                }
                else list.add(1);
            }
            else list.add(0);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 0) {
                if (remove_0 < count_0 / 2) {
                    remove_0++;
                    list.remove(i);
                }
            }
        }
        for (int i : list) {
            bw.write(i + "");
        }
        bw.flush();
    }

}
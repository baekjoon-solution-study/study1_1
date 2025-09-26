import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sub {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            int mo = 0;
            int ja = 0;
            boolean isVowels = false;
            boolean result = true;

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            if (line.equals("end")) break;

            sb.append("<").append(line).append("> is ");

            char[] arr = line.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if ("aeiou".indexOf(c) >= 0) {
                    mo++;
                    ja = 0;
                    isVowels = true;
                }
                else {
                    mo = 0;
                    ja++;
                }
                if (mo == 3 || ja == 3) {
                    result = false;
                    break;
                }
                if (i > 0 && arr[i - 1] == arr[i]) {
                    if (arr[i] != 'e' || arr[i] != 'o') {
                        result = false;
                        break;
                    }
                }
            }
            if (result && isVowels) {
                sb.append("acceptable.");
            }
            else {
                sb.append("not acceptable.");
            }
            list.add(sb.toString());
        }
        list.forEach(System.out::println);
    }
}

import java.io.*;
/**
 * 문제를 잘못 이해하여 오래걸림. 비교 시 개수 비교보다 뺄셈을 하는게 더 편하듯
 * int[] 에 index = 알파벳, value = 사용횟수 를 저장.
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] first = new int[26];
        String firstWord = br.readLine();
        for (int i = 0; i < firstWord.length(); i++) {
            first[firstWord.charAt(i) - 'A']++;
        }

        int result = 0;
        for (int i = 1; i < N; i++) {
            boolean isCorrect = true;
            int chance = 0;
            int[] temp = new int[26];
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                temp[line.charAt(j) - 'A']++;
            }
            for (int j = 0; j < 26; j++) {
                int dis = (first[j] - temp[j]) > 0 ? first[j] - temp[j] : temp[j] - first[j];
                if (dis > 1){
                    isCorrect = false;
                    break;
                }
                if (dis == 1) chance++;

            }
            int len = firstWord.length() - line.length();
            if (isCorrect && chance <= 2 && -1 <= len && len <= 1) result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }

}
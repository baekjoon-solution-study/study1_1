import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 맨 처음엔  Map에 <char, count> 이렇게 보관하다 최대, 최소 값 찾기가 까다로워 포기
 * 2. int[][] 이중 배열로 2차원 배열엔 {char, count} 이렇게 보관 후 count 를 기준으로 정렬하여 해결
 * 3. 생각해보니 char -> int 로 변환하는데 2차원 배열로 정의할 필요 없이 배열의 index를 활용하면 됐다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toUpperCase();
        /*
        char[] chars = line.toCharArray();
        int[][] arr = new int[26][2];  // 알파벳 개수 만큼 초기화 시킴.
       // Map<Character, Integer> map = new HashMap<>();

        for (char c : chars) {
            int temp = c - 'A';
            if (arr[temp][1] == 0) {
                arr[temp] = new int[] {temp, 1};  // 2차원 배열에는 {char, count}를 저장
            }
            else {
                arr[temp][1]++;
            }
            //map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int[][] sorted = Arrays
                .stream(arr)
                .sorted((o1, o2) -> o2[1] - o1[1])
                .toArray(int[][]::new);
        if (sorted[0][1] == sorted[1][1]) {
            System.out.println("?");
        }
        else {
            char temp = (char) ((char)sorted[0][0] + 'A');
            System.out.println(temp);
        }
         */
        char[] chars = line.toCharArray();
        int[] arr = new int[26];  // 알파벳 개수 만큼 초기화 시킴.

        for (char c : chars) {
            arr[c - 'A']++;  // 배열의 index를 char로 치환
        }

        int max = -1;
        int ch = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = i;
            }
            else if (arr[i] == max){
                ch = -1;
            }
        }
        if (ch == -1) {
            System.out.println("?");
        }
        else {
            System.out.println((char) (ch + 'A'));
        }
    }
}
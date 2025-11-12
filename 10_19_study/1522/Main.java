import java.io.*;
import java.util.*;

/**
 * 계산으로 풀다가 실패함.
 * 길이가 1000 이하를 보고 n^2 으로 전부 시도해보며 성공
 * 찾아보니 슬라이싱 윈도우로 a가 들어갈 크기만 정하면 됨. 즉 O(N)으로 a의 크기만큼 움직이며 b가 가장 적은 순간을 고르면 끝.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line =  br.readLine();

        char[] arr = line.toCharArray();
        int min = Integer.MAX_VALUE;
        int total_a = 0;
        int total_b = 0;

        for (char c : arr) {
            if (c == 'a') total_a++;
            else if (c == 'b') total_b++;
        }


        for (int i = 0; i < arr.length; i++) {
            int idx_count = 0;
            int count = 0;
            int idx = i;
            int temp_count = 0;
            int total;
            if (arr[i] == 'a') {
                total = total_a;
            }
            else total = total_b;

            while (idx_count < arr.length) {
                if (arr[idx] != arr[i]) count++;
                temp_count++;
                if (temp_count == total) break;
                idx_count++;
                idx++;
                idx %= arr.length;
            }
            min = Math.min(min, count);
        }
        System.out.println(min);

    }

}
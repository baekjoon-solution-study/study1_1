import java.io.*;
import java.util.*;

/**
 * DP ㅈㄴ어렵다. 5시간 걸림.
 * 2차원 배열로 계단 하나 당 상태를 여러개 저장해야함.
 * 다시 풀어볼 것
 */

public class Main {
    static int[][] stair;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        stair = new int[N + 1][2];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        if (N > 1) {

            stair[1][0] = arr[1];  // 0번 인덱스 = -1 에서 온 것
            stair[1][1] = 0;  // 1번 인덱스 = jump 한 것
            stair[2][0] = stair[1][0] + arr[2];
            stair[2][1] = stair[1][1] + arr[2];  // 1 2 3 4 5
            // 1,1  3,2  4,5  7,8

            for (int i = 3; i < N + 1; i++) {
                int first = stair[i - 2][0] + arr[i];
                int second = stair[i - 2][1] + arr[i];
                int third = stair[i - 1][1] + arr[i];

                if (first > second) {
                    stair[i][1] = first;
                }
                else {
                    stair[i][1] = second;
                }
                stair[i][0] = third;
            }

            System.out.println(Math.max(stair[N][0], stair[N][1]));
        }
        else System.out.println(arr[N]);
    }

}
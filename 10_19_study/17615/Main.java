import java.io.*;
import java.util.*;

/**
 * 1시간 20분 걸림.
 * 반례를 도저히 못찾아서 질문계시판 이용해서 반례 찾은 후 바로 해결
 * 문제가 어려운거보다 경계값을 확실히 구분해야 할 듯. 알고리즘이 필요 없음
 * 내 풀이는 하나의 for문에서 2가지를 해결하느라 복잡함. 그냥 4가지 case 를 for문으로 각자 구현하는게 훨씬 좋을 듯
*/
public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String st = br.readLine();

        char[] arr = new char[N];
        for (int i = 0; i < N; i++) {
            arr[i] = st.charAt(i);
            //System.out.print(arr[i] + " ");
        }

        int min = 0;
        char first = arr[0];
        boolean flag = false;
        int count_1 = 0;
        int count_2 = 0;
        for (int i = 1; i < N; i++) {
            if (flag == false && first != arr[i]) {
                flag = true;
                count_2++;
                continue;
            }
            if (count_2 > 0 && first != arr[i]) {   // 맨 앞의 요소가 아닌 다른 요소를 맨 앞으로 옮긴 경우
                count_2++;
            }
            if (flag == true && first == arr[i]) {
                count_1++;
            }
        }
        min = Math.min(count_1, count_2);

        count_1 = 0;
        count_2 = 0;
        flag = false;
        first = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (flag == false && first != arr[i]) {
                flag = true;
                count_2++;
                continue;
            }
            if (count_2 > 0 && first != arr[i]) {
                count_2++;
            }
            if (flag == true && first == arr[i]) {
                count_1++;
            }
        }
        int temp = Math.min(count_1, count_2);
        min = Math.min(min, temp);
        System.out.println(min);
    }

} // R R B R B R B R R R
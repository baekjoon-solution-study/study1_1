import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제 풀이보다 입출력 맞추는게 더 힘드노
 *
 * 애매한 점
 * 1. 굳이 sort() 안써도 될 듯 (차피 변 3개니 if문에 전부 체크하는게 더 빠를듯)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = new ArrayList<>();
        while(true){
            String line = br.readLine();
            if (line.equals("0 0 0")) {
                break;
            }
            //System.out.println(line);
            input.add(line);
        }
        for (String line : input) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] arr = {a,b,c};
            Arrays.sort(arr);

            if (arr[2] >= arr[0] + arr[1]) {
                System.out.println("Invalid");
            }
            else if (arr[0] == arr[2]) {  // 세 변이 같음
                System.out.println("Equilateral");
            }
            else if (arr[0] == arr[1] || arr[1] == arr[2]) {
                System.out.println("Isosceles");
            }
            else {
                System.out.println("Scalene");
            }
        }



    }
}
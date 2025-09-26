import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 돌 1개를 세번 집나 돌 3개를 1번 집나 승자는 똑같음. 즉 돌의 갯수가 홀/짝에 승패가 결정됨
 */
public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int quotient = N / 3;
    int remainder = N % 3;

    int result = quotient % 2 + remainder;
    if (result % 2 == 0) {
        System.out.println("CY");
    }
    else {
        System.out.println("SK");
    }
    }
}
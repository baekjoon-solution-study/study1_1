import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 걍 최소 Oil 만나면 지금까지 이동한 거리 총합하고 곱하면서 진행해나간다.
 * Long 으로 바꾸니깐 통과함.
 */
public class Test13305 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer road = new StringTokenizer(br.readLine());
        StringTokenizer oil = new StringTokenizer(br.readLine());

        int count = 0;
        long minOil = Integer.parseInt(oil.nextToken());
        long totalRoad = 0L;
        long result = 0L;

        while (count < N - 1) {
            totalRoad += Integer.parseInt(road.nextToken());
            long currentOil = Integer.parseInt(oil.nextToken());
            if (minOil >= currentOil || count == N - 2) {
                result += totalRoad * minOil;
                //System.out.println(minOil + " " + totalRoad + " " + result);
                minOil = currentOil;
                totalRoad = 0L;
            }
            count++;
        }
        System.out.println(result);
    }

}

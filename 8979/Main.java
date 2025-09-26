import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. Arrays.sort() 에 하나의 요소가 아닌 여러 요소를 정렬할 수 있음을 알게됨.
 * 2. 이거 정렬할 필요가 없었음. 금메달이 나보다 많으면 1 증가, 금메달이 같고 은메달이 나보다 많으면 1 증가... 이렇게 하면 되는데 ㅆㅂ
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine());
        int countryNum = Integer.parseInt(line.nextToken());
        int selectCountryNum = Integer.parseInt(line.nextToken());
        int[][] medals = new int[countryNum][4];

        int[] select = new int[4];
        for (int i = 0; i < countryNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // country, gold, silver, bronze 순으로 저장
            for (int j = 0; j < 4; j++) {
                medals[i][j] = Integer.parseInt(st.nextToken());
            }
            if (medals[i][0] == selectCountryNum) {  // 내가 찾고자하는 나라를 저장.
                select = medals[i];
            }
        }
        /*  -> 개선된 풀이
        int count = 1;
        for (int i = 0; i < countryNum; i++) {
            if (medals[i] == select) {  // 자기 자신은 무시
                continue;
            }
            if (medals[i][1] > select[1] || (medals[i][1] == select[1] && medals[i][2] > select[2])
                    || (medals[i][1] == select[1] && medals[i][2] == select[2]  && medals[i][3] > select[3])) {
                count++;
            }
        }
        System.out.println(count);

         */

        Arrays.sort(medals, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    return o2[3] - o1[3];
                }
                return o2[2] - o1[2];
            }
            return o2[1] - o1[1];
        });

        int rank = 1;
        int duplication = 1;

        for (int i = 0; i < countryNum; i++) {

            if (medals[i][0] == selectCountryNum) {
                break;
            }
            int[] dup = medals[i + 1];
            if (medals[i][1] == dup[1] && medals[i][2] == dup[2] && medals[i][3] == dup[3]) {
                duplication++;
            } else {
                rank += duplication;
                duplication = 1;
            }
        }

        for (int[] i : medals) {
            System.out.println(i[0] + " " + i[1] + " " + i[2] + " " + i[3]);
        }

        //System.out.println(rank);
    }
}
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 처음에 Team Class 를 만들까 생각했지만 굳이라는 생각에 그냥 2차원 배열로 해결
 * 성능은 좋을지 몰라도 Class로 구현 후 sort도 따로 구현(implements Comparable<Team>)으로 가독성을 챙길 수 있을듯
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int question_num = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] score = new int[n + 1][question_num + 1];
            int[][] submit = new int[n + 1][2];  // 제출 횟수, 가장 최근 제출
            int[][] entry = new int [m][3];
            for (int j = 0; j < m; j++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                entry[j][0] =  Integer.parseInt(st1.nextToken()); // id
                entry[j][1] = Integer.parseInt(st1.nextToken()); // 문제 번호
                entry[j][2] =  Integer.parseInt(st1.nextToken()); // 점수
            }

            for (int j = 0; j < m; j++) {
                int[] q = entry[j];
                int myId = q[0];
                int myScoreNum = q[1];
                int myScore = q[2];
                if (score[myId][myScoreNum] < myScore) {
                    score[myId][myScoreNum] = myScore;
                }
                submit[myId][0]++;
                submit[myId][1] = j;
            }

            int resultScore = Arrays.stream(score[id]).sum();
            int myRank = 1;

            for (int j = 0; j < n + 1; j++) {
                int temp = Arrays.stream(score[j]).sum();
                if (temp > resultScore) myRank++;
                else if (temp == resultScore) {
                    if (submit[j][0] < submit[id][0]) {
                        myRank++;
                    }
                    else if (submit[j][0] == submit[id][0]) {
                        if (submit[j][1] < submit[id][1]) {
                            myRank++;
                        }
                    }
                }
            }
            bw.write(myRank + "\n");
        }
        bw.flush();
    }

}
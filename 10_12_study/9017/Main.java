import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * team을 초기에 2차원 배열로 만들었지만 그냥 class를 만드는게 더 좋아보여서 변경
 */
public class Test9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cases = new int[N][];

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] scores = new int[M];

            for (int j = 0; j < M; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }
            cases[i] = scores;
        }

        for (int i = 0; i < N; i++) {
            int result = 0;
            int[] member = cases[i];
            Map<Integer, Integer> checkSix = new HashMap<>();
            Map<Integer, Integer> score = new HashMap<>();

            for (int j = 0; j < member.length; j++) {  // Map에 넣음
                checkSix.put(member[j], checkSix.getOrDefault(member[j], 0) + 1);
            }

            int rank = 1;
            for (int j = 0; j < member.length; j++) {
                int num = member[j];
                if (checkSix.get(num) == 6) {  // 6명 이상인 팀만 점수를 얻음
                    score.put(num, score.getOrDefault(num, 0) + rank++);
                }
            }

            List<Integer> duplicationRank = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : score.entrySet()) {  // Rank가 가장 작은 값을 찾음
                if (entry.getValue() < min)  min = entry.getValue();
            }
            for (Map.Entry<Integer, Integer> entry : score.entrySet()) {  // Rank가 가장 작은 값들은 list에 저장
                if (entry.getValue() == min) duplicationRank.add(entry.getKey());
            }
            for (int j : duplicationRank) System.out.println(j);
            if (duplicationRank.size() == 1) result = duplicationRank.get(0);
            else {
                Map<Integer, Integer> ranks = new HashMap<>();
                for (int num : duplicationRank) {
                    int count = 0;
                    for (int j = 0; j < member.length; j++) {
                        if (member[j] == num) count++;
                        if (count == 5) {
                            ranks.put(num, j);
                            break;
                        }
                    }
                }
                int idx = 0;
                int min_rank = Integer.MAX_VALUE;
                for (Map.Entry<Integer, Integer> entry : ranks.entrySet()) {
                    if (entry.getValue() < min_rank) {
                        min_rank = entry.getValue();
                        idx = entry.getKey();
                    }
                }
                result = idx;
            }
            System.out.println(result);
        }
    }
}

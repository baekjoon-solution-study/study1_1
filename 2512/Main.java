import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 해결방법
 * 1. 예산액 정렬 후 경계값을 찾음. 경계값과 그 다음값을 1씩 더하며 for문 돌려서 최적의 값 찾. O(NlogN)
 * 2. 이분탐색으로 최대값만 찾고 /2 하며 찾음.
 */
public class Test2512 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int max = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        long total = Long.parseLong(br.readLine());
        int result = 0;
        if (sum > total) {
            int min = 1;

            while(min <= max) {   // 이분탐색
                int currentSum = 0;
                int middle = (max + min) / 2;
                for (int num : arr) {
                    if (middle > num) {
                        currentSum += num;
                    }
                    else {
                        currentSum += middle;
                    }
                }
                if (currentSum <= total) {  // 예산에 들어옴
                    min = middle + 1;  // middle은 이미 검증했으니 +1
                    result = middle;  // 결과값 저장
                }
                else {
                    max = middle - 1;  // middle은 이미 검증했으니 -1
                }
            }
        }
        else {
            result = max;
        }
        bw.write(String.valueOf(result));
        bw.flush();



		/*
		Arrays.sort(arr);

		int idx = 0;
		int tempIdx = N;
		for (int i = 0; i < N; i++) {
			long temp = arr[i] * tempIdx;
			if (temp <= total) {
				idx = i;
				tempIdx--;
				total -= arr[i];
			}
			else {
				break;
			}
		}

		long result = arr[idx];

		if (idx < N - 1) {
			for (int i = arr[idx]; i <= arr[idx + 1]; i++) {
				long temp = i * tempIdx;
				if (temp > total) {
					result = i - 1;
					break;
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		*/


    }

}

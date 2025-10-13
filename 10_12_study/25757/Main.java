import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        String game = str.nextToken();

        Set<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            set.add(name);
        }

        int size = set.size();
        if (game.equals("Y")) {
            count = size;
        }
        else if (game.equals("F")) {
            count = size / 2;
        }
        else if (game.equals("O")) {
            count = size / 3;
        }
        System.out.println(count);

    }
}
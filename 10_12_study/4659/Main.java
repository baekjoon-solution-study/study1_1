import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            boolean result = true;
            boolean oneVowel = false;

            if (line.equals("end")) {
                break;
            }
            sb.append("<").append(line).append("> is ");

            char[] arr = line.toCharArray();
            char[] vowels = {'a', 'e', 'i', 'o', 'u'};

            List<Character> stack = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                boolean isVowel = isVowels(c, vowels);

                if (isVowel) oneVowel = true;

                if (stack.size() > 0) {
                    char past = stack.get(stack.size() - 1);
                    boolean isVowelPast = isVowels(past, vowels);
                    if (c == past) {
                        if ((c == 'e' || c == 'o') == false) {
                            result = false;
                            break;
                        }
                    }
                    if (stack.size() > 1) {
                        char pp = stack.get(stack.size() - 2);
                        boolean isVowelPp = isVowels(pp, vowels);
                        if ((isVowel && isVowelPast && isVowelPp) || (!isVowel && !isVowelPast && !isVowelPp)) {
                            result = false;
                            break;
                        }
                    }
                }
                stack.add(c);
            }
            if (result && oneVowel) {
                sb.append("acceptable.");
            }
            else {
                sb.append("not acceptable.");
            }
            list.add(sb.toString());
        }
        list.forEach(System.out::println);
    }
    public static boolean isVowels(char c, char[] vowels) {
        for (char c1 : vowels) {
            if (c == c1) {
                return true;
            }
        }
        return false;
    }
}
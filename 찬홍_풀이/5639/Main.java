import java.io.*;
import java.util.*;

/**
 * 5639
 *
 * 이진 탐색 트리는 왼쪽/오른쪽이 명확히 존재하므로 List<List<>> 보다 Node class로 다루는 것이 확실히 편함.
 * 이중 리스트에 간선을 넣는 방식을 택했다가 오류 폭탄맞아서 방향성 보고 다시 풀이.
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Node {
        int num;
        Node left;
        Node right;

        Node(int num) {
            this.num = num;
        }
        void insert (int num) {
            if (this.num > num) {
                if (this.left == null) {
                    this.left = new Node(num);
                }
                else this.left.insert(num);
            }
            else if (this.num < num) {
                if (this.right == null) {
                    this.right = new Node(num);
                }
                else this.right.insert(num);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> nodes = new ArrayList<>();
        while(true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;
            nodes.add(Integer.parseInt(input));
        }

        if (nodes.size() == 1) {  // 1 인 경우 예외처리
            System.out.println(nodes.get(0));
            return;
        }

        Node root = new Node(nodes.get(0));
        for (int i = 1; i < nodes.size(); i++) {
            int next = nodes.get(i);
            root.insert(next);
        }

        search(root);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
    static void search(Node root) {  // 후위탐색
        if (root.left != null) {
            search(root.left);
        }
        if (root.right != null) {
            search(root.right);
        }
        sb.append(root.num).append("\n");
    }
}

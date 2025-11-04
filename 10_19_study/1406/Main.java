import java.io.*;
import java.util.*;

/**
 * LinkedList 문제인건 바로 알았는데 이용해서 문제풀이나 구현은 처음이라 못품.
 * LinkedList 자료구조 처음 써봄. 동작방식 공부하느라 문제를 푼게 아닌듯.
 * 직접 LinkedList 구현해봄 (ㅈㄴ오래걸림)
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       /* LinkedList<Character> list = new LinkedList<>();
        String firstLine = br.readLine();
        for (int i = 0; i < firstLine.length(); i++) {
            list.add(firstLine.charAt(i));
        }
        ListIterator<Character> listIterator = list.listIterator(list.size());
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if (command == 'D') {
                if (listIterator.hasNext()) {
                    listIterator.next();
                }
            } else if (command == 'L') {
                if (listIterator.hasPrevious()) {
                    listIterator.previous();
                }
            }

             *//*listIterator 의 remove() 는 커서의 위치가 아닌 통과한 노드를 삭제함.
             즉 remove() -> remove() 이런 명렁어는 불가능.
             next() or previous() 을 통해 노드를 이동하고 이동한 노드를 삭제함.*//*

            else if (command == 'B') {
                if (listIterator.hasPrevious()) {
                    listIterator.previous();
                    listIterator.remove();

                }
            } else if (command == 'P') {
                char input = st.nextToken().charAt(0);
                listIterator.add(input);
            }
        }
        for (char c : list) {
            if (c != '0') {
                sb.append(c);
            }
        }
        bw.write(sb.toString());
        bw.flush();*/
        Node head = new Node();
        Node current = head;
        Node node;
        String firstLine = br.readLine();
        for (int i = 0; i < firstLine.length(); i++){
            char c = firstLine.charAt(i);
            node = new Node(c, current);
            current.next = node;
            current = node;
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            System.out.println("data : " + current.data);
            switch (command) {
                case 'L':
                    if (current.prev != null) {
                        current = current.prev;
                    }
                    break;
                case 'D':
                    if (current.next != null) {
                        current = current.next;
                    }
                    break;
                case 'B':
                    if (current == head) break;
                    if (current.next == null) {
                        current.prev.next = null;
                        current = current.prev;
                        break;
                    }
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current = current.prev;
                    break;
                case 'P':
                    char input = st.nextToken().charAt(0);
                    Node node1 = new Node();
                    node1.prev = current;
                    node1.data = input;
                    if (current.next != null) {
                        node1.next = current.next;
                        current.next.prev = node1;
                    }
                    current.next = node1;
                    current = node1;
                    break;
            }
        }
    }

    public static class Node {
        Character data;
        Node next, prev;
        public Node() {}
        public Node(char data, Node current) {
            this.data = data;
            this.prev = current;
        }
    }
}

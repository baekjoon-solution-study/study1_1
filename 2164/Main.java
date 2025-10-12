import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        MyQueue queue = new MyQueue();

        for (int i = 0; i < N; i++) {
            queue.enqueue(i + 1);
        }
        int count = 0;
        while (count < N - 1) {
            //queue.print();
            queue.dequeue();

            int temp = queue.dequeue();
            queue.enqueue(temp);
            count++;

            //System.out.println(queue.count + " " + queue.current);
        }
        System.out.println(queue.top());

    }
    public static class MyQueue {
        int[] queue = new int[10];
        int current = 0;
        int size = 10;
        int count = 0;

        public void enqueue(int num) {
            if (size == count) {
                size *= 10;
                int[] temp = new int[size];
                for (int i = 0; i < queue.length; i++) {
                    temp[i] = queue[i];
                }
                queue = temp;
                queue[count] = num;
                count++;
            }
            else {
                queue[count] = num;
                count++;
            }
        }

        public int dequeue() {

            int temp = queue[current++];
            return temp;
        }

        public int top() {
            return queue[current];
        }

        public void print() {
            for (int i : queue) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

}

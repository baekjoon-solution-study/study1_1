import java.io.*;
import java.util.*;

/**
 * 구현방법 까먹어서 거의 보면서함.
 * push 를 잘못 구현해서 며칠동안 버렸다가 해결함
 */

public class Main {
    static ArrayList<Integer> heap = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        heap = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > 0) push(value);
            else if (value == 0 && heap.isEmpty()) {
                sb.append("0").append("\n");
            }
            else {
                sb.append(pop()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static void push(int value) {
        heap.add(value);
        int child = heap.size() - 1;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (heap.get(child) < heap.get(parent)) {
                int temp = heap.get(child);
                heap.set(child, heap.get(parent));
                heap.set(parent, temp);
                child = parent;
            }
            else break;
        }
    }

    public static int pop() {
        int result = heap.get(0);
        int lastValue = heap.remove(heap.size() - 1);

        if (heap.isEmpty()) {
            return result;
        }
        heap.set(0, lastValue);  // 마지막 요소를 맨 처음으로 가져온 후 아래로 내려가며 정렬

        int parent = 0;
        while (true) {
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            int smallest = parent;
            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }
            if (smallest == parent) break;

            int temp = heap.get(smallest);
            heap.set(smallest, heap.get(parent));
            heap.set(parent, temp);
            parent = smallest;

        }
        return result;
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.offer(num);
            } else if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(num);
            }

            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int temp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(temp);
                }
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
    }
}

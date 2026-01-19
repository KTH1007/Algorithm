import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String[] tokens;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int q = Integer.parseInt(br.readLine());

            Queue<Long> minHeap = new PriorityQueue<>();
            Queue<Long> maxHeap = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
            Map<Long, Integer> map = new HashMap<>();

            for (int i = 0; i < q; i++) {
                tokens = br.readLine().split(" ");

                String str = tokens[0];
                long num = Integer.parseInt(tokens[1]);

                if ("I".equals(str)) {
                    minHeap.add(num);
                    maxHeap.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);

                } else {
                    if (minHeap.isEmpty() || maxHeap.isEmpty()) {
                        continue;
                    }

                    if (num == 1) {
                        while (!maxHeap.isEmpty() && map.getOrDefault(maxHeap.peek(), 0) == 0) {
                            maxHeap.poll();
                        }

                        if (!maxHeap.isEmpty()) {
                            long maxNum = maxHeap.poll();
                            map.put(maxNum, map.get(maxNum) - 1);
                        }
                    } else if (num == -1) {
                        while (!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(), 0) == 0) {
                            minHeap.poll();
                        }

                        if (!minHeap.isEmpty()) {
                            long minNum = minHeap.poll();
                            map.put(minNum, map.get(minNum) - 1);
                        }
                    }
                }
            }


            while (!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(), 0) == 0) {
                minHeap.poll();
            }

            while (!maxHeap.isEmpty() && map.getOrDefault(maxHeap.peek(), 0) == 0) {
                maxHeap.poll();
            }

            if (maxHeap.isEmpty() || minHeap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}

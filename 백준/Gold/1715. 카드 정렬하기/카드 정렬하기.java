import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 최소힙 사용
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        // 최소 값 2개를 뽑아 더해서 다시 최소힙에 넣어준다.
        while (queue.size() > 1) {
            int compareCount = queue.poll() + queue.poll();
            answer += compareCount;
            queue.add(compareCount);
        }

        System.out.println(answer);
    }
}

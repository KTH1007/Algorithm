import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 양수 최대힙 사용
        Queue<Integer> positive = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 음수 최소힙 사용
        Queue<Integer> negative = new PriorityQueue<>();
        int zeroCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) positive.add(num);
            else if (num == 0) zeroCount++;
            else negative.add(num);
        }

        int answer = 0;

        // 양수의 경우 모두 곱해서 넣어주고 마지막 하나가 남게 되면 바로 더해준다.
        while (positive.size() > 1) {
            int a = positive.poll();
            int b = positive.poll();
            if (a == 1 || b == 1) {
                answer += (a + b);
            } else {
                answer += (a * b);
            }
        }

        if (positive.size() == 1) answer += positive.poll();

        // 음수의 경우 모두 곱해서 넣어주고 마지막 수가 남게 되면 0이 있는지 체크 후 있으면 0 없으면 그 수 그대로
        while (negative.size() > 1) {
            int a = negative.poll();
            int b = negative.poll();
            answer += (a * b);
        }

        if (negative.size() == 1) {
            if (zeroCount >= 1) answer += 0;
            else answer += negative.poll();
        }

        System.out.println(answer);
    }
}

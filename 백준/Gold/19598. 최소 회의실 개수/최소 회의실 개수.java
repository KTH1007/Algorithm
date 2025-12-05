import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Lecture {
    private int startTime;
    private int endTime;

    public Lecture(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tokens;

        Queue<Lecture> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getStartTime() == o2.getStartTime()) {
                return o1.getEndTime() - o2.getEndTime();
            }
            return o1.getStartTime() - o2.getStartTime();
        });

        while (n-- > 0) {
            tokens = br.readLine().split(" ");
            int startTime = Integer.parseInt(tokens[0]);
            int endTime = Integer.parseInt(tokens[1]);
            Lecture lecture = new Lecture(startTime, endTime);

            queue.add(lecture);
        }

        Queue<Integer> endTimeQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        endTimeQueue.add(queue.poll().getEndTime());

        while (!queue.isEmpty()) {
            if (endTimeQueue.peek() > queue.peek().getStartTime()) {
                endTimeQueue.add(queue.poll().getEndTime());
            } else {
                endTimeQueue.poll();
                endTimeQueue.add(queue.poll().getEndTime());
            }
        }

        System.out.println(endTimeQueue.size());
    }
}

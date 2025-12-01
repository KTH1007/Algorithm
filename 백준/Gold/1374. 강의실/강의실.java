import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Lecture {
    private int number;
    private int startTime;
    private int endTime;

    public Lecture(int number, int startTime, int endTime) {
        this.number = number;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getNumber() {
        return number;
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
            int number = Integer.parseInt(tokens[0]);
            int startTime = Integer.parseInt(tokens[1]);
            int endTime = Integer.parseInt(tokens[2]);

            Lecture lecture = new Lecture(number, startTime, endTime);
            queue.add(lecture);
        }

        int lectureEndTime = queue.poll().getEndTime();
        Queue<Integer> endQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        endQueue.add(lectureEndTime);

        while (!queue.isEmpty()) {
            Lecture currentLecture = queue.poll();
            int currentStartTime = currentLecture.getStartTime();
            int currentEndTime = currentLecture.getEndTime();

            if (endQueue.peek() > currentStartTime) {
                endQueue.add(currentEndTime);
            } else {
                endQueue.poll();
                endQueue.add(currentEndTime);
            }
        }

        System.out.println(endQueue.size());
    }
}

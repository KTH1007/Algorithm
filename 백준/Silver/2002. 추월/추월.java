import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<String> tunnel1 = new ArrayDeque<>();
        Queue<String> tunnel2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            tunnel1.offer(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            tunnel2.offer(br.readLine());
        }

        int count = 0;

        while (!tunnel2.isEmpty()) {
            String car = tunnel2.poll();
            if (!car.equals(tunnel1.peek())) {
                count++;
                tunnel1.remove(car);
            } else {
                tunnel1.poll();
            }
        }

        System.out.println(count);
    }
}

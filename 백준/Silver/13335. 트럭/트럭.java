import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getTime(trucks, w, l));
    }

    private static int getTime(int[] trucks, int w, int l) {
        int currentWeight = 0;
        int time = 0;
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int truck : trucks) {
            while (true) {
                if (bridge.isEmpty()) { // 다리가 비어있는 경우
                    bridge.add(truck);
                    currentWeight += truck;
                    time++;
                    break;
                } else if (bridge.size() != w) { // 다리에 트럭이 있는 경우
                    if (currentWeight + truck <= l) {
                        bridge.add(truck);
                        currentWeight += truck;
                        time++;
                        break;
                    } else { // 무게 때문에 들어가지 못하면 큐에 빈 값을 넣어줘야 됨
                        bridge.add(0);
                        time++;
                    }
                } else {
                    currentWeight -= bridge.poll();
                }
            }
        }

        // 다리에 대기중인 트럭 시간도 더해줌
        time += w;
        return time;
    }
}

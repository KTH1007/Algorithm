import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int step = 0;
    static List<Belt> conveyor = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            conveyor.add(i, new Belt(Integer.parseInt(st.nextToken())));
        }

        while (k > 0) {
            moveConveyor();
            moveRobot();
        }

        System.out.println(step);
    }

    private static void moveConveyor() {
        step++;
        conveyor.add(0, conveyor.remove(conveyor.size() - 1));
        if (conveyor.get(n - 1).robot) {
            conveyor.get(n - 1).robot = false;
        }
    }

    private static void moveRobot() {
        for (int i = n - 2; i >= 0; i--) {
            if (!conveyor.get(i).robot) continue;;

            if (conveyor.get(i + 1).robot || conveyor.get(i + 1).durability <= 0) continue;

            conveyor.get(i).robot = false;
            conveyor.get(i + 1).putRobot();
            if (conveyor.get(i + 1).durability <= 0) k--;

            if (i + 1 == n - 1) conveyor.get(i + 1).robot = false;
        }

        if (conveyor.get(0).durability > 0) {
            conveyor.get(0).putRobot();
            if (conveyor.get(0).durability <= 0) k--;
        }
    }

    private static class Belt {
        int durability;
        boolean robot;

        public Belt(int durability) {
            this.durability = durability;
            this.robot = false;
        }

        public void putRobot() {
            durability--;
            robot = true;
        }
    }
}

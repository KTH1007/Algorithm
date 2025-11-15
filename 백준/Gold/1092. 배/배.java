import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> cranes = new ArrayList<>();

        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(tokens[i]));
        }
        cranes.sort((o1, o2) -> o2 - o1);

        int m = Integer.parseInt(br.readLine());

        tokens = br.readLine().split(" ");
        List<Integer> boxs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boxs.add(Integer.parseInt(tokens[i]));
        }
        boxs.sort((o1, o2) -> o2 - o1);
        int result = move(cranes, boxs);

        System.out.println(result);
    }

    private static int move(List<Integer> cranes, List<Integer> boxs) {
        int count = 0;

        if (cranes.get(0) < boxs.get(0)) {
            return -1;
        }

        while (!boxs.isEmpty()) {
            count++;

            int craneIndex = 0;
            int boxIndex = 0;

            while (craneIndex < cranes.size()) {
                if (boxIndex >= boxs.size()) {
                    break;
                }
                if (cranes.get(craneIndex) >= boxs.get(boxIndex)) {
                    boxs.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }
        }

        return count;
    }
}

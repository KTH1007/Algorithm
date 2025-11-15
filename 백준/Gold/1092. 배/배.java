import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] crane = new int[n];

        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(tokens[i]);
        }
        Arrays.sort(crane);

        int m = Integer.parseInt(br.readLine());

        tokens = br.readLine().split(" ");
        List<Integer> boxs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boxs.add(Integer.parseInt(tokens[i]));
        }
        boxs.sort((o1, o2) -> o2 - o1);
        int result = move(crane, boxs, n, m);

        System.out.println(result);
    }

    private static int move(int[] crane, List<Integer> boxs, int n, int m) {
        int count = 0;

        if (crane[n - 1] < boxs.get(0)) {
            return -1;
        }

        while (true) {
            count++;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < boxs.size(); j++) {
                    if (crane[i] >= boxs.get(j)) {
                        boxs.remove(j);
                        break;
                    }
                }
            }

            if (boxs.isEmpty()) {
                break;
            }
        }

        return count;
    }
}

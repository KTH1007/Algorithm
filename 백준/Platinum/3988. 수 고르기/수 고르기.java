import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        int[] v = new int[n];
        tokens = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(tokens[i]);
        }

        Arrays.sort(v);

        int windowSize = n - k;

        TreeMap<Integer, Integer> diffCount = new TreeMap<>();
        for (int i = 0; i < windowSize - 1; i++) {
            int diff = v[i + 1] - v[i];
            diffCount.merge(diff, 1, Integer::sum);
        }

        int M = v[windowSize - 1] - v[0];
        int m = diffCount.firstKey();
        min = Math.min(min, M + m);

        for (int i = 1; i <= k; i++) {
            int left = i;
            int right = i + windowSize - 1;

            int removeDiff = v[left] - v[left - 1];
            diffCount.merge(removeDiff, -1, Integer::sum);
            if (diffCount.get(removeDiff) == 0) {
                diffCount.remove(removeDiff);
            }

            int addDiff = v[right] - v[right - 1];
            diffCount.merge(addDiff, 1, Integer::sum);

            M = v[right] - v[left];
            m = diffCount.firstKey();
            min = Math.min(min, M + m);
        }

        System.out.println(min);
    }

}

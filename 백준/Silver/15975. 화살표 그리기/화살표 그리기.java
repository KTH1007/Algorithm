import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Map<Integer, List<Integer>> colorMap = new HashMap<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            if (!colorMap.containsKey(color)) {
                colorMap.put(color, new ArrayList<>());
            }
            colorMap.get(color).add(x);
        }

        long sum = 0;
        for (List<Integer> value : colorMap.values()) {
            if (value.size() == 1) continue;
            value.sort(null);
            for (int i = 0; i < value.size(); i++) {
                int leftDist = (i > 0) ? value.get(i) - value.get(i - 1) : Integer.MAX_VALUE;
                int rightDist = (i < value.size() - 1) ? value.get(i + 1) - value.get(i) : Integer.MAX_VALUE;

                sum += Math.min(leftDist, rightDist);
            }
        }

        System.out.println(sum);


    }

}

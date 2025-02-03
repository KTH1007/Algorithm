import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            max = Math.max(max, map.get(arr[i]));
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        double avg = (double) sum / n;
        int answer = (int) Math.round(avg);

        int num = 0;

        List<int[]> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == max) {
                list.add(new int[]{i, map.get(i)});
            }
        }

        list.sort((int[] o1, int[] o2) -> {
            if (o2[1] == o1[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });

        if (list.size() > 1 && list.get(0)[1] == list.get(1)[1]) {
            num = list.get(1)[0];
        } else {
            num = list.get(0)[0];
        }

        sb.append(answer).append("\n").append(arr[n / 2]).append("\n").append(num).append("\n").append(arr[arr.length - 1] - arr[0]);

        System.out.println(sb);
    }
}

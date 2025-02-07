import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;

        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, list.get(i));
        }

        for (int i = 0; i < n; i++) {
            sum += list.get(i) + max;
        }

        System.out.println(sum - (max * 2));
    }
}

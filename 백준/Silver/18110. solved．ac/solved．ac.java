import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = (int) Math.round(n * 0.15);
        List<Integer> list = new ArrayList<>();
        double sum = 0;

        while (n-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int size = list.size() - (count * 2);

        Collections.sort(list);
        for (int i = count; i < list.size() - count; i++) {
            sum += list.get(i);
        }
        int avg = (int) Math.round(sum / size);
        System.out.println(avg);
        br.close();
    }
}

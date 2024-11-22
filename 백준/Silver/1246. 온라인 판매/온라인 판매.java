import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort((o1, o2) -> o2 - o1);

        int maxPrice = Integer.MIN_VALUE;
        int maxTotal = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int price = list.get(i);
            int total = 0;
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (count >= n) {
                    break;
                }
                if (list.get(j) >= price) {
                    total += price;
                    count++;
                }
            }
            if (maxTotal <= total) {
                maxTotal = total;
                maxPrice = price;
            }
        }

        System.out.println(maxPrice + " " + maxTotal);
    }
}

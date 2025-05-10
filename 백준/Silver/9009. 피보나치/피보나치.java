import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] fib = new int[46];
        fib[1] = 1;
        for (int i = 2; i < 46; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            for (int i = 45; i >= 0; i--) {
                if (n == 0) continue;
                if (n >= fib[i]) {
                    list.add(fib[i]);
                    n -= fib[i];
                }
            }
            list.sort((o1, o2) -> o1 - o2);
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}

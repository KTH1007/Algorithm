import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        // flase = 소수
        boolean[] prime = new boolean[1000001];

        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= 1000000; i++) {
            if (!prime[i]) {  // i가 소수라면
                for (int j = i * i; j <= 1000000; j += i) prime[j] = true;
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            int count = 0;

            for (int i = 2; i <= n / 2; i++) {
                if (!prime[i] && !prime[n - i]) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }


}



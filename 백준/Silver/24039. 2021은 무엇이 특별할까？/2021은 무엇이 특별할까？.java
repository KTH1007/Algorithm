import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static boolean[] prime = new boolean[100001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        isPrime();


        for (int i = 2; i < 100001; i++) {
            if (prime[i]) list.add(i);
        }

        int result;
        int i = 0;
        while (true) {
            result = list.get(i) * list.get(i + 1);
            if (result > n) {
                break;
            }
            i++;
        }

        System.out.println(result);
    }

    private static void isPrime() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i <= Math.sqrt(100000); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 100000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

}

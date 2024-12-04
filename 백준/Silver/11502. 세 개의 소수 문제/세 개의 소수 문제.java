import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        boolean[] primeArray = new boolean[1001];
        primeArray[0] = primeArray[1] = false;
        Arrays.fill(primeArray, true);
        isPrime(primeArray);

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<Integer> list = new ArrayList<>();
            boolean flag = false;

            listAdd(n, primeArray, list);
            if (list.isEmpty()) {
                sb.append(0).append("\n");
            } else {
                list.sort(null);
                for (Integer i : list) {
                    sb.append(i).append(" ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }

    private static void listAdd(int n, boolean[] primeArray, List<Integer> list) {
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < n; j++) {
                for (int k = 2; k < n; k++) {
                    if (primeArray[i] && primeArray[j] && primeArray[k] && i + j + k == n) {
                            list.add(i);
                            list.add(j);
                            list.add(k);
                            return;
                        }
                }
            }
        }
    }

    private static void isPrime(boolean[] primeArray) {
        for (int i = 2; i < 1001; i++) {
            if (primeArray[i]) {
                for (int j = i * i; j < 1001; j += i) {
                    primeArray[j] = false;
                }
            }
        }
    }

}

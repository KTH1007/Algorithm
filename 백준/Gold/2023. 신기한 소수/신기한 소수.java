import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static List<String> selected = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs("");

        Collections.sort(selected);
        StringBuilder sb = new StringBuilder();

        for (String s : selected) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(String num) {
        if (num.length() == n) {
            selected.add(num);
            return;
        }

        for (int i = 1; i < 10; i++) {
            String newNum = num + i;
            if (isPrime(Integer.parseInt(newNum))) {
                dfs(newNum);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}

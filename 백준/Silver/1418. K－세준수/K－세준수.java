import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (count(i, k)) count++;
        }

        System.out.println(count + 1);
    }

    private static boolean count(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                list.add(i);
                n /= i;
            }
        }

        list.sort((o1, o2) -> o1 - o2);
        if (list.isEmpty()) return false;
        if (list.get(list.size() - 1) <= k) return true;
        return false;
    }
}

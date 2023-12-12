import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) list.add(Integer.parseInt(br.readLine()));


        int diff = 0;
        int GCD = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            diff = list.get(i + 1) - list.get(i);
            GCD = gcd(diff, GCD);
        }

        // 심은 나무 수 - 기존 나무 수
        System.out.println((list.get(n - 1) - list.get(0)) / GCD + 1 - list.size());

    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}



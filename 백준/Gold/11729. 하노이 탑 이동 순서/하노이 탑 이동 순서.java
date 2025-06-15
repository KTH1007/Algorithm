import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);
        System.out.println((int) Math.pow(2, n) - 1);
        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start + " " + to).append("\n");
            return;
        }
        // a -> c
        hanoi(n - 1, start, to, mid);
        sb.append(start + " " + to).append("\n");
        hanoi(n - 1, mid, start, to);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] circle = new int[n];
        for (int i = 0; i < n; i++) {
            circle[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            int gcd = gcd(circle[0], circle[i]);
            sb.append(circle[0] / gcd).append("/").append(circle[i] / gcd).append("\n");
        }

        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

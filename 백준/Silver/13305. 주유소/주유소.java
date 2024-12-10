import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        int[] oil = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            oil[i] = num;
        }

        long totalPrice = 0;
        int prevPrice = oil[0];

        for (int i = 0; i < n - 1; i++) {
            if (oil[i] < prevPrice) {
                prevPrice = oil[i];
            }
            totalPrice += (long) distance[i] * prevPrice;
        }

        System.out.println(totalPrice);
    }
}

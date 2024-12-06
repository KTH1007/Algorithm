import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] alphabet = new boolean[26];
        char[] roulette = new char[n];
        Arrays.fill(roulette, '?');

        int index = 0;

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            index = (index + n - (s % n)) % n;

            if (roulette[index] == c) continue;

            if (roulette[index] == '?' && !alphabet[c- 'A']) {
                alphabet[c - 'A'] = true;
                roulette[index] = c;
            } else {
                System.out.println("!");
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(roulette[(index + i) % n]);
        }

        System.out.println(sb);
    }
}

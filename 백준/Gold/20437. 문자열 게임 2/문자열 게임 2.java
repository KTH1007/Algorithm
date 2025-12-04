import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;
            int[] alpha = new int[26];

            for (int i = 0; i < w.length(); i++) {
                alpha[w.charAt(i) - 'a']++;
            }

            for (int i = 0; i < w.length(); i++) {
                if (alpha[w.charAt(i) - 'a'] < k) {
                    continue;
                }

                int count = 1;
                for (int j = i + 1; j < w.length(); j++) {
                    if (w.charAt(i) == w.charAt(j)) {
                        count++;
                    }

                    if (count == k) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }

        System.out.println(sb);
    }
}

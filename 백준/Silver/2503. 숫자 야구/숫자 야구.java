import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] check = new boolean[988];

        init(check);

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int j = 123; j < 988; j++) {
                if (!check[j]) continue;

                int strikeCount = 0;
                int ballCount = 0;

                String num = Integer.toString(j);
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (s.charAt(k) == num.charAt(l)) {
                            if (k == l) strikeCount++;
                            else ballCount++;
                        }
                    }
                }

                if (strike != strikeCount || ball != ballCount) check[j] = false;
            }
        }
        int count = checkCount(check);
        System.out.println(count);
    }

    private static void init(boolean[] check) {
        for (int i = 123; i < 988; i++) {
            String s = Integer.toString(i);
            if (s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0') continue;
            if (s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(0) == s.charAt(2)) continue;
            check[i] = true;
        }
    }

    private static int checkCount(boolean[] check) {
        int count = 0;
        for (int i = 123; i < 988; i++) {
            if (check[i]) count++;
        }
        return count;
    }

}

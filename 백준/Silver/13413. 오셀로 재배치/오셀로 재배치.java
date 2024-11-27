import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            String s2 = br.readLine();

            sb.append(getCount(s1, s2)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getCount(String s1, String s2) {
        int wCount = 0;
        int bCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'W') {
                    wCount++;
                } else {
                    bCount++;
                }
            }
        }

        int min = Math.min(wCount, bCount);
        int count = 0;
        while (min-- > 0) {
            wCount--;
            bCount--;
            count++;
        }
        return count + wCount + bCount;
    }
}

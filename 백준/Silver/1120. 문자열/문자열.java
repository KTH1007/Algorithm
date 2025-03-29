import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String x = st.nextToken();
        String y = st.nextToken();

        int min = Integer.MAX_VALUE;
        if (y.contains(x)) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) count++;
        }

        min = Math.min(min, count);

        int left = 0;
        int right = y.length() - x.length();

        while (left <= right) {
            count = 0;
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) != y.charAt(left + i)) count++;
            }
            min = Math.min(min, count);
            left++;
        }

        System.out.println(min);
    }
}

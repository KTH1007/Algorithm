import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        sum += 8 * (n - 1);

        int day = sum / 24;
        int hour = sum % 24;

        System.out.println(day + " " + hour);
    }

}

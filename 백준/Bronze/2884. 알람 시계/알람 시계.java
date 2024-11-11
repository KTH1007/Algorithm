import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        if (second - 45 >= 0) {
            second -= 45;
        } else {
            hour--;
            second = second + 15;
        }

        if (hour < 0) {
            hour = 23;
        }

        System.out.println(hour + " " + second);
    }
}

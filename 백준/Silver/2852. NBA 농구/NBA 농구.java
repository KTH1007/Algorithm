import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int score1 = 0;
        int score2 = 0;

        int leadTime1 = 0;
        int leadTime2 = 0;


        int time = 0;

        int enidTime = 48 * 60;

        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String temp = st.nextToken();

            int now = Integer.parseInt(temp.substring(0, 2)) * 60 + Integer.parseInt(temp.substring(3));

            if (score1 > score2) {
                leadTime1 += now - time;
            } else if (score1 < score2) {
                leadTime2 += now - time;
            }

            if (team == 1) score1++;
            else score2++;

            time = now;
        }

        if (score1 > score2) {
            leadTime1 += enidTime - time;
        } else if (score1 < score2) {
            leadTime2 += enidTime - time;
        }

        System.out.println(cal(leadTime1));
        System.out.println(cal(leadTime2));
    }

    private static String cal(int a) {
        String minute = Integer.toString(a / 60);
        if (minute.length() == 1) minute = "0" + minute;
        String second = Integer.toString(a % 60);
        if (second.length() == 1) second = "0" + second;

        return minute + ":" + second;
    }

}

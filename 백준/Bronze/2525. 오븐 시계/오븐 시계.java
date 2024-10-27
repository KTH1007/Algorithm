import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());

        if (time + minute > 59) {
            hour += (time + minute) / 60;
            minute = (time + minute) % 60;
            if (hour > 23) {
                hour %= 24;
            }
        } else {
            minute += time;
        }

        System.out.println(hour + " " + minute);
    }
}

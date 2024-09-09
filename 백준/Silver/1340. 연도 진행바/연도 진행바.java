import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class Main {
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] monthArr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int month = 0;
        int day;
        int year;
        int hour;
        int minute;

        String temp = st.nextToken();

        for (int i = 0; i < 12; i++) {
            if (monthArr[i].equals(temp)) {
                month = i + 1;
                break;
            }
        }

        day = Integer.parseInt(st.nextToken().substring(0, 2));
        year = Integer.parseInt(st.nextToken());

        String[] time = st.nextToken().split(":");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);

        LocalDateTime newYear = LocalDateTime.of(year, 1, 1, 0, 0);
        LocalDateTime current = LocalDateTime.of(year, month, day, hour, minute);


        Duration duration = Duration.between(newYear, current);

        long diff = duration.toMinutes();

        boolean flag = false;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            flag = true;
        }

        double num = 525600.0;
        if (flag) num = 527040.0;

        double result = ((double) diff / num) * 100;
        System.out.println(result);
    }

}

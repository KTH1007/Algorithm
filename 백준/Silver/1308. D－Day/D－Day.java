import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] monthArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int nextYear = Integer.parseInt(st.nextToken());
        int nextMonth = Integer.parseInt(st.nextToken());
        int nextDay = Integer.parseInt(st.nextToken());

        if (nextYear - year > 1000 || (nextYear - year == 1000 && month <= nextMonth && day <= nextDay)) {
            System.out.println("gg");
            return;
        }

        int total1 = countDay(year, month, day);
        int total2 = countDay(nextYear, nextMonth, nextDay);

        System.out.println("D-" + (total2 - total1));

        br.close();
    }

    private static int countLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return 1;
        }
        return 0;
    }

    private static int countDay(int year, int month, int day) {
        int total = 0;
        for (int i = 1; i < year; i++) {
            total += 365 + countLeapYear(i);
        }
        for (int i = 1; i < month; i++) {
            if (i == 2) total += countLeapYear(year);
            total += monthArr[i];
        }
        return total + day;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int todayYear = Integer.parseInt(st.nextToken());
        int todayMonth = Integer.parseInt(st.nextToken());
        int todayDay = Integer.parseInt(st.nextToken());

        int age = todayYear - year;
        if (age == 0) System.out.println(0);
        else {
            if (todayMonth > month) System.out.println(age);
            else if (todayMonth == month) {
                if (todayDay >= day) System.out.println(age);
                else System.out.println(age - 1);
            } else System.out.println(age - 1);
        }

        int koreaAge = age + 1;
        System.out.println(koreaAge);
        System.out.println(age);
    }

}

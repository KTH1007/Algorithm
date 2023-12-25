import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int second = 0;

        for (int i = 0; i < 4; i++) second += Integer.parseInt(br.readLine());

        int minute = second / 60;
        second %= 60;

        System.out.println(minute);
        System.out.println(second);

    }


}



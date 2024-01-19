import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int time = 0;
        int temperature = a;

        if (temperature < 0) {
            time = a * -1 * c;
            temperature = 0;
        }
        if (temperature == 0) time += d;
        if (temperature < b) {
            int temp = b - temperature;
            time += temp * e;
        }

        System.out.println(time);
    }
}

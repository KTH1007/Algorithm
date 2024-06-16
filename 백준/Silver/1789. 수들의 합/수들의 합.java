import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long sum = 0;
        int count = 0;

        for (int i = 1; ; i++) {
            if (sum > num) break;
            sum += i;
            count++;
        }
        System.out.println(count - 1);
        br.close();
    }


}

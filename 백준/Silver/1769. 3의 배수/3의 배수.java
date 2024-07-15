import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String y = br.readLine();

        int count = 0;
        while (y.length() > 1) {
            int sum = 0;
            for (int i = 0; i < y.length(); i++) {
                sum += y.charAt(i) - '0';
            }
            count++;
            y = Integer.toString(sum);
        }

        System.out.println(count);
        if (Integer.parseInt(y) % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        br.close();
    }
}

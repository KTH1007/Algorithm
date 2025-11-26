import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int total = 0;
        int num = Integer.parseInt(n);
        if (num < 10) {
            for (int i = 0; i < num; i++) {
                total++;
            }
            System.out.println(total);
        } else {
            total = 9;
            String start = "10";
            while (true) {
                int sum = 0;
                for (int i = 0; i < start.length(); i++) {
                    String s = String.valueOf(start.charAt(i));
                    sum += Integer.parseInt(s);
                }
                int number = Integer.parseInt(start);
                if (number % sum == 0) {
                    total++;
                }
                number++;
                if (number > Integer.parseInt(n)) break;
                start = String.valueOf(number);
            }
            System.out.println(total);
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String temp1 = s.substring(0, s.length() / 2);
        String temp2 = s.substring(s.length() / 2);

        if (op(temp1) == op(temp2)) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }

    }

    private static int op(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return sum;
    }
}

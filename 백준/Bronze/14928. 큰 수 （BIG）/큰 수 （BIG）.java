import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        long temp = 0;

        for (int i = 0; i < s.length(); i++) {
            temp = (temp * 10 + (s.charAt(i) - '0')) % 20000303;
        }

        System.out.println(temp);

    }

}

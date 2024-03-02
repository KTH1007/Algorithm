import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 15; i++) {
            String s = br.readLine();
            if (s.contains("w")) {
                System.out.println("chunbae");
                break;
            } else if (s.contains("b")) {
                System.out.println("nabi");
                break;
            } else if (s.contains("g")) {
                System.out.println("yeongcheol");
                break;
            }
        }
    }
}

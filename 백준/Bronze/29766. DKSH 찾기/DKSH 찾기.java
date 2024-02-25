import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 0;

        if (s.length() >= 4) {
            for (int i = 0; i < s.length() - 3; i++) {
                if (s.substring(i, i + 4).equals("DKSH")) count++;
            }
        }

        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int bCount = 0;
        int rCount = 0;

        char currentColor = 'N';
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'B') {
                if (currentColor != 'B') {
                    bCount++;
                    currentColor = 'B';
                }
            } else if (s.charAt(i) == 'R') {
                if (currentColor != 'R') {
                    rCount++;
                    currentColor = 'R';
                }
            }
        }
        System.out.println(Math.min(bCount, rCount) + 1);
    }
}

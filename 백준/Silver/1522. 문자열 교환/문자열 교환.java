import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int countA = 0;
        int minB = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (i + countA <= s.length()) {
                minB = Math.min(minB, checkBCount(s.substring(i, i + countA)));
            } else {
                minB = Math.min(minB, checkBCount(s.substring(i) + s.substring(0, (i + countA) % s.length())));
            }
        }

        System.out.println(minB);
    }

    private static int checkBCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                count++;
            }
        }
        return count;
    }
}

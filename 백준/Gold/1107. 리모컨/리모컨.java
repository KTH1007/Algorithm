import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int target;
    static Set<Integer> broken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        broken = new HashSet<>();

        if (m > 0) {
            String[] tokens = br.readLine().split(" ");

            for (int i = 0; i < m; i++) {
                broken.add(Integer.parseInt(tokens[i]));
            }
        }

        min = Math.abs(target - 100);

        for (int i = 0; i <= 999999; i++) {
            if (canMake(i)) {
                int digitCount = String.valueOf(i).length();
                int diffCount = Math.abs(target - i);

                min = Math.min(min, digitCount + diffCount);
            }
        }

        System.out.println(min);
    }

    private static boolean canMake(int channel) {
        String num = String.valueOf(channel);
        for (int i = 0; i < num.length(); i++) {
            if (broken.contains(num.charAt(i) - '0')) {
                return false;
            }
        }

        return true;
    }

}

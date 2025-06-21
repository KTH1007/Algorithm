import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final String[] patterns = {
        "TTT", "TTH", "THT", "THH",
        "HTT", "HTH", "HHT", "HHH"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < P; test++) {
            String line = br.readLine();
            int[] counts = new int[8];

            for (int i = 0; i <= 37; i++) {
                String sub = line.substring(i, i + 3);
                for (int j = 0; j < 8; j++) {
                    if (patterns[j].equals(sub)) {
                        counts[j]++;
                        break;
                    }
                }
            }

            for (int cnt : counts) {
                sb.append(cnt).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
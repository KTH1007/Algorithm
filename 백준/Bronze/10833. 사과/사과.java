import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int schoolCount = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < schoolCount; i++) {
            final String[] input = br.readLine().split(" ");
            final int studentCount = Integer.parseInt(input[0]);
            final int appleCount = Integer.parseInt(input[1]);
            sum += (appleCount % studentCount);
        }

        System.out.print(sum);

    }
}
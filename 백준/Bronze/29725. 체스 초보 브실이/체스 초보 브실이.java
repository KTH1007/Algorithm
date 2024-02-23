import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int white = 0;
        int black = 0;

        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                char c = s.charAt(j);
                if (c == 'P') white += 1;
                else if (c == 'p') black += 1;
                else if (c == 'N') white += 3;
                else if (c == 'n') black += 3;
                else if (c == 'B') white += 3;
                else if (c == 'b') black += 3;
                else if (c == 'R') white += 5;
                else if (c == 'r') black += 5;
                else if (c == 'Q') white += 9;
                else if (c == 'q') black += 9;
            }
        }

        System.out.println(white - black);
    }

}

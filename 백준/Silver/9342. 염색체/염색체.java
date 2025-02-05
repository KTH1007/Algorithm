import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            String s = br.readLine();
            String str = "[A-F]?A+F+C+[A-F]?$";
            boolean matches = s.matches(str);
            if (matches) sb.append("Infected!").append("\n");
            else sb.append("Good").append("\n");
        }

        System.out.println(sb);
    }
}

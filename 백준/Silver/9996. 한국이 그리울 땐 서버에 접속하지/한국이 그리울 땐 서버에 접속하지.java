import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        String regex = pattern.replace("*", ".*");
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String s = br.readLine();
            if (s.matches(regex)) sb.append("DA").append("\n");
            else sb.append("NE").append("\n");
        }

        System.out.println(sb);
    }

}

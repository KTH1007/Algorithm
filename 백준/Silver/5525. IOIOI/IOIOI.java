import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // I OI+

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int count = 0;

        Pattern pattern = Pattern.compile("(?=I(OI)" + "{" + n + "})");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            count++;
        }

        System.out.println(count);
    }
}

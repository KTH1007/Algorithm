import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        int start = 0;
        StringBuilder sb = new StringBuilder();

        while (length > 0) {
            if (length >= 10) {
                sb.append(s.substring(start, start + 10)).append("\n");
            } else {
                sb.append(s.substring(start)).append("\n");
                break;
            }
            length -= 10;
            start += 10;
        }

        System.out.println(sb);
    }

}

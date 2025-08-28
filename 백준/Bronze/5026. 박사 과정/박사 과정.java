import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int questionSize = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < questionSize; i++) {
            String curStr = br.readLine();

            if (curStr.equals("P=NP")) {
                sb.append("skipped\n");
            } else {
                StringTokenizer st = new StringTokenizer(curStr, "+");
                int lNum = Integer.parseInt(st.nextToken());
                int rNum = Integer.parseInt(st.nextToken());
                sb.append((lNum + rNum) + "\n");
            }
        }

        System.out.println(sb);

    }
}

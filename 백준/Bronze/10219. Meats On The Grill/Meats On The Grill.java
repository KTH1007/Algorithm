import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                StringBuilder temp = new StringBuilder();
                temp.append(line).reverse();
                sb.append(temp.toString()).append("\n");
                temp.setLength(0);
            }
        }
        System.out.println(sb);
    }

}

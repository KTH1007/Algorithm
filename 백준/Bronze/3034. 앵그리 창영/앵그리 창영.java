import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(br.readLine());

            if (Math.pow(length, 2) > Math.pow(w, 2) + Math.pow(h, 2)) {
                sb.append("NE").append("\n");
            } else sb.append("DA").append("\n");
        }
        System.out.println(sb);
    }
}

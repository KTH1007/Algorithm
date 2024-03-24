import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        double min = x / y * 1000;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());

            min = Math.min(min, x / y * 1000);
        }

        System.out.println(String.format("%.2f", min));
    }

}

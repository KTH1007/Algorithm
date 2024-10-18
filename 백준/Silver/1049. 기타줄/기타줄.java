import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int packageMin = Integer.MAX_VALUE;
        int unitMin = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int packagePrice = Integer.parseInt(st.nextToken());
            int pricePerUnit = Integer.parseInt(st.nextToken());
            packageMin = Math.min(packageMin, Math.min(packagePrice, pricePerUnit * 6));
            unitMin = Math.min(unitMin, pricePerUnit);
        }

        if (n % 6 == 0) {
            min = Math.min(min, packageMin * (n / 6));
        } else {
            min = Math.min(min, packageMin * (n / 6) + (unitMin * (n % 6)));
            min = Math.min(min, packageMin * ((n / 6) + 1));
        }

        System.out.println(min);
    }
}

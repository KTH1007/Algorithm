import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());

        double i = Double.parseDouble(st.nextToken());
        double j = Double.parseDouble(st.nextToken());
        double k = Double.parseDouble(st.nextToken());

        StringBuilder sb = new StringBuilder();

        double ratio = Math.min(Math.min(a / i, b / j), c / k);

        double remainA = a - (i * ratio);
        double remainB = b - (j * ratio);
        double remainC = c - (k * ratio);

        sb.append(remainA).append(" ").append(remainB).append(" ").append(remainC);
        System.out.println(sb);
    }

}

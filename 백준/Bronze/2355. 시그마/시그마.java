import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        long min = Math.min(a, b);
        long max = Math.max(a, b);

        long temp1 = (max * (max + 1)) / 2;
        long temp2 = ((min - 1) * min) / 2;

        System.out.println(temp1 - temp2);

    }
}

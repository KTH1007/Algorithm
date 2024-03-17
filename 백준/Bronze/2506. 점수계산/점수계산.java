import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }

        System.out.println(sum);

    }

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 136) sum += 1000;
            else if (a == 142) sum += 5000;
            else if (a == 148) sum += 10000;
            else if (a == 154) sum += 50000;
        }
        System.out.println(sum);

    }

}

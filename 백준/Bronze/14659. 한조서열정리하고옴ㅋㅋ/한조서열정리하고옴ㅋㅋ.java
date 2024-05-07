import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int current = Integer.parseInt(st.nextToken());
        int count = 0;
        for (int i = 1; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (current > temp) {
                count++;
            } else {
                current = temp;
                max = Math.max(max, count);
                count = 0;
            }
        }

        max = Math.max(max, count);

        System.out.println(max);
    }

}

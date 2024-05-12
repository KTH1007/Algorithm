import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] arr = new int[l + 1];
        int max = 0;
        int result1 = 0;
        int max2 = 0;
        int result2 = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (k - p + 1 > max) {
                max = k - p + 1;
                result1 = i;
            }

            int count = 0;
            for (int j = p; j <= k; j++) {
                if (arr[j] == 0) {
                    arr[j] = 1;
                    count++;
                }
            }

            if (count > max2) {
                max2 = count;
                result2 = i;
            }
        }

        System.out.println(result1);
        System.out.println(result2);

    }

}

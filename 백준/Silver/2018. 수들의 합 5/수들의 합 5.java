import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int i = 1;
        int j = 1;
        int n = Integer.parseInt(br.readLine());

        while (i <= j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += k;
            }
            if (sum == n) {
                j++;
                count++;
            } else if (sum > n) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println(count);
    }

}

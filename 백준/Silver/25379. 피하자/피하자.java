import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        long leftCount = 0;
        long rightCount = 0;
        long sum = 0;
        int idx = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isEven(num)) {
                sum += idx++;
                leftCount += i;
                rightCount += n - 1 - i;
            }
        }

        System.out.println(Math.min(leftCount, rightCount) - sum);
    }

    private static boolean isEven(int num) {
        if (num % 2 == 0) return true;
        return false;
    }
}

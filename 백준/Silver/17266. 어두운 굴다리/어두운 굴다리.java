import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] x = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n;
        int answer = n;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isCovered(n, x, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isCovered(int n, int[] x, int h) {
        int lastCovered = 0;
        for (int lamp : x) {
            if (lamp - h > lastCovered) {
                return false;
            }
            lastCovered = lamp + h;
        }
        return lastCovered >= n;
    }

}

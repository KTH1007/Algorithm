import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] check = new int[100001];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = 1;

        while (right <= n) {
            if (check[arr[right]] < k) {
                check[arr[right]]++;
                right++;
            } else {
                check[arr[left]]--;
                left++;
            }

            max = Math.max(max, right - left);

        }

        System.out.println(max);
    }
}

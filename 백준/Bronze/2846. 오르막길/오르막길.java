import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i]) {
                temp = arr[i];
            } else {
                max = Math.max(max, arr[i] - temp);
            }
        }

        System.out.println(max);
    }

}

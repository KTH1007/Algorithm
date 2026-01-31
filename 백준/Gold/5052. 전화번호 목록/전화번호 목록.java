import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);
            boolean flag = false;
            for (int i = 1; i < n; i++) {
                if (arr[i].length() >= arr[i - 1].length()) {
                    if (arr[i].substring(0, arr[i - 1].length()).equals(arr[i - 1])) {
                        sb.append("NO").append("\n");
                        flag = true;
                        break;
                    }
                }
            }

            if (!flag) {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);
    }
}

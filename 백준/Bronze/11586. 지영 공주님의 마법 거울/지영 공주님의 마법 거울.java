import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int k = Integer.parseInt(br.readLine());

        if (k == 1) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append("\n");
            }
        } else if (k == 2) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < n; i++) {
                temp.append(arr[i]);
                sb.append(temp.reverse()).append("\n");
                temp.setLength(0);
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                sb.append(arr[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}

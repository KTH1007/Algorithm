import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[9];
        for (int i = 0; i < 8; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Arrays.fill(arr, 8, arr.length, 9999);
        Arrays.sort(arr);

        for (int i = 0; i < n - 8; i++) {
            double d = Double.parseDouble(br.readLine());
            for (int j = 0; j < 7; j++) {
                if (arr[j] >= d) {
                    for (int k = 7; k >= j; k--) {
                        arr[k + 1] = arr[k];
                    }
                    arr[j] = d;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            String temp = String.format("%.3f", arr[i]);
            sb.append(temp).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

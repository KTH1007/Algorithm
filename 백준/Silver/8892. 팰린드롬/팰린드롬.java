import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String[] arr = new String[k];
            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < k; i++) {
                arr[i] = br.readLine();
            }

            boolean flag = false;
            for (int i = 0; i < k; i++) {
                if (flag) break;
                for (int j = 0; j < k; j++) {
                    if (i == j) continue;
                    temp.setLength(0);
                    temp.append(arr[i]).append(arr[j]);
                    temp = temp.reverse();

                    String s = arr[i] + arr[j];
                    if (s.equals(temp.toString())) {
                        flag = true;
                        sb.append(s).append("\n");
                        break;
                    }
                }
            }
            if (!flag) sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

}

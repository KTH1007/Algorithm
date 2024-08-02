import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (p-- > 0) {
            int[] arr = new int[20];
            int count = 0;
            st = new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken())).append(" ");
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

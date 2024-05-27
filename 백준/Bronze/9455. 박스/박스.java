import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int n, m, count, temp;
        int[][] arr;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            count = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < m; i++) {
                temp = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (arr[j][i] == 0) temp++;
                    else if (arr[j][i] == 1 && temp != 0) {
                        count += temp;
                        arr[j][i] = 0;
                    }
                }
            }
            sb.append(count).append("\n");

        }

        System.out.println(sb);
    }
}

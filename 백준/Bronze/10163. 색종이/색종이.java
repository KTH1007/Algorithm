import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[1002][1002];
        int[] result = new int[101];
        HashMap<Integer, Integer> map = new HashMap<>();

        int x, y, w, h;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + w; j++) {
                for (int k = y; k < y + h; k++) {
                    arr[k][j] = i;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 1002; j++) {
                for (int k = 0; k < 1002; k++) {
                    if (arr[k][j] == i) result[i]++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);


    }

}

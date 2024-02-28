import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(st.nextToken()) * 100 / n;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (arr[i] <= 4) sb.append(1).append(" ");
            else if (arr[i] > 4 && arr[i] <= 11) sb.append(2).append(" ");
            else if (arr[i] > 11 && arr[i] <= 23) sb.append(3).append(" ");
            else if (arr[i] > 23 && arr[i] <= 40) sb.append(4).append(" ");
            else if (arr[i] > 40 && arr[i] <= 60) sb.append(5).append(" ");
            else if (arr[i] > 60 && arr[i] <= 77) sb.append(6).append(" ");
            else if (arr[i] > 77 && arr[i] <= 89) sb.append(7).append(" ");
            else if (arr[i] > 89 && arr[i] <= 96) sb.append(8).append(" ");
            else sb.append(9).append(" ");
        }

        System.out.println(sb);
    }

}

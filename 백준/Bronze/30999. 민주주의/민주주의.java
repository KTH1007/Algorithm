import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0;
        int count;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            count = 0;
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'O') count++;
            }
            if (count > m / 2) answer++;
        }
        System.out.println(answer);
    }
}

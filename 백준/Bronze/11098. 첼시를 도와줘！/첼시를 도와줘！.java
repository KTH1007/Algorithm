import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            int sal = 0, max = Integer.MIN_VALUE, num = 0;
            String[] players = new String[p];
            for (int j = 0; j < p; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                sal = Integer.parseInt(st.nextToken());
                players[j] = st.nextToken();
                if (max < sal) {
                    max = sal;
                    num = j;
                }
            }
            System.out.println(players[num]);
        }
    }
}
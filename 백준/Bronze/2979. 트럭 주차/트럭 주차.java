import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;

        int [] time = new int[100];

        for (int i = 0; i < 3; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(s.nextToken());
            int end = Integer.parseInt(s.nextToken());
            
            for (int j = start-1; j < end-1; j++) {
                time[j]++;
            }
        }

        for (int i : time) {
            if (i == 1) {
                ans += i * a;
            } else if (i == 2) {
                ans += i * b;
            } else if (i == 3) {
                ans += i * c;
            }
        }

        System.out.println(ans);
    }
}
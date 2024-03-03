import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int STR = Integer.parseInt(st.nextToken());
        int DEX = Integer.parseInt(st.nextToken());
        int INT = Integer.parseInt(st.nextToken());
        int LUK = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int sum = STR + DEX + INT + LUK;

        int count = 0;
        while (true) {
            if (sum / 4 >= n) break;
            sum += 1;
            count++;
        }

        System.out.println(count);
    }
}

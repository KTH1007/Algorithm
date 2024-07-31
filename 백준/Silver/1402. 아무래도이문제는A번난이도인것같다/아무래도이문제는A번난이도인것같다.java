import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 6 5  -> 6 * -1 * -1 * 1,  6 - 1 - 1 + 1
        while (t-->0) {
            sb.append('y').append('e').append('s').append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}

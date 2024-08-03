import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n-- > 0) {
            String s = br.readLine();
            s += s;
            if (s.contains(key)) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            boolean flag = true;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - 1)) {
                    s = s.replace(s.charAt(j - 1), '!');
                }
                if (s.charAt(j) == '!') {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;

        }
        System.out.println(count);
    }


}

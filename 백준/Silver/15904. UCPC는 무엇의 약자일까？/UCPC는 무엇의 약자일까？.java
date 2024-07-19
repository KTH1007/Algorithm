import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean[] check = new boolean[4];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (count > 3) break;
            if (s.charAt(i) == "UCPC".charAt(count)) {
                check[count++] = true;
            }
        }

        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (!check[i]) flag = false;
        }

        if (flag) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");
        
        br.close();
    }

}

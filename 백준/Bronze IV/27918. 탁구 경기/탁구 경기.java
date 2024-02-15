import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int x = 0;
        int y = 0;
        while (n-- > 0) {
            String s = br.readLine();
            if (s.equals("D")) x++;
            else y++;

            if (Math.abs(x - y) == 2) break;
        }

        System.out.println(x + ":" + y);
    }


}

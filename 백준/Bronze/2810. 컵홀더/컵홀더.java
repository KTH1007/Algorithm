import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        s = s.replace("S", "*S*").replace("LL", "*LL*").replace("**", "*");

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') count++;
        }

        System.out.println(Math.min(n, count));


    }

}

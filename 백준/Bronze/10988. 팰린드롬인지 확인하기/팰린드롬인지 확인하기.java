import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        String s2 = sb.append(s).reverse().toString();
        if (s.equals(s2)) System.out.println(1);
        else System.out.println(0);
    }


}

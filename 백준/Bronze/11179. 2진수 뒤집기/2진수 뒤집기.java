import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = Integer.toString(n, 2);

        StringBuilder sb = new StringBuilder();
        sb.append(s).reverse();

        String temp = sb.toString();

        System.out.println(Integer.parseInt(temp, 2));
    }

}

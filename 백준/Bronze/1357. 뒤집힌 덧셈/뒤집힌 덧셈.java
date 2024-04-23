import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(sb.append(st.nextToken()).reverse().toString());
        sb.setLength(0);
        int b = Integer.parseInt(sb.append(st.nextToken()).reverse().toString());

        int sum = a + b;
        sb.setLength(0);
        sb.append(sum).reverse();

        sum = Integer.parseInt(sb.toString());

        System.out.println(sum);


    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = (int) (n - (n * 0.22));
        int b = (int) (n - (n * 0.2) * 0.22);
        System.out.println(a + " " + b);

    }

}

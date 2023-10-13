import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int a = n * (m % 10);
        int b = n * ((m % 100) / 10);
        int c = n * (m / 100);
        sb.append(a).append("\n").append(b).append("\n").append(c).append("\n").append(n * m);
        System.out.println(sb);
    }


}

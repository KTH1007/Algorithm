import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = n / 4;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }


}
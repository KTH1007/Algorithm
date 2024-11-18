import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = "";
        int count = 1;
        int num = 666;
        while (count != n) {
            num++;
            if (String.valueOf(num).contains("666")) count++;
        }

        System.out.println(num);

    }
}

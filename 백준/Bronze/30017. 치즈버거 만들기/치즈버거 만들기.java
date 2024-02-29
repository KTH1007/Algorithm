import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int size = 0;
        if (a > b) size = 2 * b + 1;
        else if (a == b) size = a + b - 1;
        else size = 2 * a - 1;
        System.out.println(size);
    }

}

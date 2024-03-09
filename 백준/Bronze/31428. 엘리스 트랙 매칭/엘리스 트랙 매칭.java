import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = br.readLine();

        int count = 0;

        for (int i = 0; i < n; i++) if (st.nextToken().equals(s)) count++;
        System.out.println(count);
    }
}

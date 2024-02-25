import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        if (n >= 1000) {
            if (u >= 8000 || l >= 260) System.out.println("Very Good");
            else System.out.println("Good");
        } else System.out.println("Bad");
    }
}

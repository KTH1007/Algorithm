import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder temp = new StringBuilder();
        String s;
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            temp.append(s).reverse();
            sb.append(temp).append("\n");
            temp.setLength(0);
        }

        System.out.println(sb);
    }

}

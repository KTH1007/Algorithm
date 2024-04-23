import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int l, p, v;
        int i = 1;
        int n;
        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            if (l == 0 && p == 0 && v == 0) break;
            n = (v / p) * l;
            if ((v % p) >= l) n += l;
            else n += (v % p);
            sb.append("Case ").append(i).append(": ").append(n).append("\n");
            i++;

        }

        System.out.println(sb);


    }
}

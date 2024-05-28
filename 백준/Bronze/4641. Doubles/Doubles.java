import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(st.nextToken());
            if (n == -1) break;
            list.add(n);

            int length = st.countTokens();
            while (length-- > 0) {
                n = Integer.parseInt(st.nextToken());
                if (n == 0) break;
                list.add(n);
            }

            for (int i : list) {
                if (list.contains(i * 2)) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}

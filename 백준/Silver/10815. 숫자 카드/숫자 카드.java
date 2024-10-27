import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int check = Integer.parseInt(st.nextToken());
            if (set.contains(check)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}

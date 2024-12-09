import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                count++;
                list.add(s);
            }
        }

        list.sort(null);

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }
}

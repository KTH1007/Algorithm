import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>();

        while (l-- > 0) {
            String s = br.readLine();
            if (set.contains(s)) {
                set.remove(s);
                set.add(s);
            } else set.add(s);
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext() && k-- > 0) {
            sb.append(iterator.next()).append("\n");
        }

        System.out.println(sb);
    }

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 & c == 0) break;

            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            Collections.sort(list);

            if (list.get(0) + list.get(1) > list.get(2)) {
                if (a == b && b == c) sb.append("Equilateral").append("\n");
                else if (a == b || a == c || b == c) sb.append("Isosceles").append("\n");
                else sb.append("Scalene").append("\n");
            } else sb.append("Invalid").append("\n");

        }
        System.out.println(sb);

    }


}


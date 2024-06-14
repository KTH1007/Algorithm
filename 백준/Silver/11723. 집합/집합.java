import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st;
        int n;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("add")) {
                n = Integer.parseInt(st.nextToken());
                list.add(n);
            } else if (s.equals("remove")) {
                n = Integer.parseInt(st.nextToken());
                if (list.contains(n)) {
                    list.remove(Integer.valueOf(n));
                }
            } else if (s.equals("check")) {
                n = Integer.parseInt(st.nextToken());
                if (list.contains(n)) {
                    sb.append(1).append("\n");
                } else sb.append(0).append("\n");
            } else if (s.equals("toggle")) {
                n = Integer.parseInt(st.nextToken());
                if (list.contains(n)) {
                    list.remove(Integer.valueOf(n));
                } else list.add(n);
            } else if (s.equals("all")) {
                list = new ArrayList<>();
                for (int i = 1; i <= 20; i++)
                    list.add(i);
            } else if (s.equals("empty")) {
                list = new ArrayList<>();
            }
        }

        System.out.println(sb);
    }


}

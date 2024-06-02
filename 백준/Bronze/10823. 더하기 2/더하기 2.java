import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        String s;
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), ",");
        while (st.hasMoreTokens()) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
    }

}

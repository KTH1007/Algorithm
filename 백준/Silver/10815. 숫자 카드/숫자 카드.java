import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> card = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) card.put(Integer.parseInt(st.nextToken()), 1);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (card.containsKey(a)) sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.println(sb);
    }


}



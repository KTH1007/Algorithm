import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if (p < l) {
                br.readLine();
                if (m > 0) {
                    m--;
                    count++;
                }
                continue;
            }
            List<Integer> score = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < p; i++) {
                score.add(Integer.parseInt(st.nextToken()));
            }

            score.sort(null);
            list.add(score.get(p - l));
        }

        list.sort(null);
        for (int i = 0; i < list.size(); i++) {
            if (m - list.get(i) >= 0) {
                m -= list.get(i);
                count++;
            }
        }

        System.out.println(count);
    }

}

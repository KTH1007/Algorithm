import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Power> power = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            power.add(new Power(name, score));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (num > power.get(mid).getScore()) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(power.get(left).getName()).append("\n");
        }

        System.out.println(sb);


    }

    static class Power {
        private String name;
        private int score;

        public Power(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }

}

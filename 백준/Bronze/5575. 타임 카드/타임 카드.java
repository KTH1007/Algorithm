import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int h1, h2, m1, m2, s1, s2;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            h1 = Integer.parseInt(st.nextToken());
            m1 = Integer.parseInt(st.nextToken());
            s1 = Integer.parseInt(st.nextToken());
            h2 = Integer.parseInt(st.nextToken());
            m2 = Integer.parseInt(st.nextToken());
            s2 = Integer.parseInt(st.nextToken());
            commute(h1, m1, s1, h2, m2, s2);
        }

        System.out.println(sb);
    }

    static void commute(int h1, int m1, int s1, int h2, int m2, int s2) {
        int h = h2 - h1;
        int m = m2 - m1;
        int s = s2 - s1;

        if (s < 0) {
            m--;
            s += 60;
        }
        if (m < 0) {
            h--;
            m += 60;
        }
        sb.append(h).append(" ").append(m).append(" ").append(s).append("\n");
    }


}



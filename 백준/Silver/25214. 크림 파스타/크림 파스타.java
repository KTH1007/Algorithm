import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int current = 0;
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            current = Integer.parseInt(st.nextToken());
            min = Math.min(min, current);
            answer = Math.max(answer, current - min);
            sb.append(answer).append(" ");
        }
        System.out.println(sb);

    }


}
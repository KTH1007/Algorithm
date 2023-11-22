import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int current = Integer.parseInt(st.nextToken());
            min = Math.min(min, current);
            max = Math.max(max, current - min);
        }

        System.out.println(max);
    }


}


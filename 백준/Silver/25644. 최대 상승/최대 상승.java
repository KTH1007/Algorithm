import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 현재값 - 최솟값
        int answer = 0;
        int min = Integer.MAX_VALUE;
        while (n-- > 0) {
            int current = Integer.parseInt(st.nextToken());
            min = Math.min(min, current);
            answer = Math.max(answer, current - min);
        }
        System.out.println(answer);

    }


}


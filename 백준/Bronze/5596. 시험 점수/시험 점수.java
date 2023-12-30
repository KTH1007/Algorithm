import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int s = 0;
        int t = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) s += Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) t += Integer.parseInt(st.nextToken());

        max = Math.max(s, t);
        System.out.println(max);
    }


}



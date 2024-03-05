import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lv = Integer.parseInt(st.nextToken());
        String s = st.nextToken();

        int answer = 0;
        if (s.equals("miss")) answer = 0;
        else if (s.equals("bad")) answer = 200 * lv;
        else if (s.equals("cool")) answer = 400 * lv;
        else if (s.equals("great")) answer = 600 * lv;
        else if (s.equals("perfect")) answer = 1000 * lv;

        System.out.println(answer);
    }
}

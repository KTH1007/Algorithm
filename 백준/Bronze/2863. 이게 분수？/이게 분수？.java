import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        /*
        경우의 수
         a/c b/d  c/d a/b   d/b c/a   b/a  d/c
         */

        int max = (a / c) + (b / d);
        int count = 0;

        max = Math.max(
                Math.max((a / c) + (b / d), (c / d) + (a / b)),
                Math.max((d / b) + (c / a), (b / a) + (d / c))
        );


        if ((b / a) + (d / c) == max) {
            max = (b / a) + (d / c);
            count = 3;
        } else if ((d / b) + (c / a) == max) {
            max = (d / b) + (c / a);
            count = 2;
        } else if ((c / d) + (a / b) == max) {
            max = (c / d) + (a / b);
            count = 1;
        }

        System.out.println(count);
    }

}

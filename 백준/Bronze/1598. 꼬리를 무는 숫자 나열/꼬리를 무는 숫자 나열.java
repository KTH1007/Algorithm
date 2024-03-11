import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int h = 0;
        int w = 0;

        if (a % 4 == 1) h = 0;
        else if (a % 4 == 2) h = 1;
        else if (a % 4 == 3) h = 2;
        else if (a % 4 == 0) h = 3;

        if (b % 4 == 1) h = Math.abs(h - 0);
        else if (b % 4 == 2) h = Math.abs(h - 1);
        else if (b % 4 == 3) h = Math.abs(h - 2);
        else if (b % 4 == 0) h = Math.abs(h - 3);

        if (a % 4 != 0) {
            w = a / 4;
        } else w = a / 4 - 1;

        if (b % 4 != 0) {
            w = Math.abs(w - (b / 4));
        } else w = Math.abs(w - (b / 4 - 1));

        System.out.println(h + w);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int d = Integer.parseInt(br.readLine());


        int temp = c;
        c = (c + d) % 60;
        d = (temp + d) / 60;

        temp = b;
        b = (b + d) % 60;
        d = (temp + d) / 60;

        a = (a + d) % 24;

        System.out.println(a + " " + b + " " + c);

    }


}



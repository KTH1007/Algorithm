import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());

        if ((sum + minus) % 2 != 0 || sum < minus) System.out.println(-1);
        else System.out.println(((sum + minus) / 2) + " " + (((sum + minus) / 2) - minus));

    }


}



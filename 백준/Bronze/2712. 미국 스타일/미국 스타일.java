import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            double n = Double.parseDouble(st.nextToken());
            String s = st.nextToken();
            if (s.equals("kg")) {
                System.out.printf("%.4f lb", n * 2.2046);
                System.out.println();
            } else if (s.equals("l")) {
                System.out.printf("%.4f g", n * 0.2642);
                System.out.println();
            } else if (s.equals("lb")) {
                System.out.printf("%.4f kg", n * 0.4536);
                System.out.println();
            } else if (s.equals("g")) {
                System.out.printf("%.4f l", n * 3.7854);
                System.out.println();
            }
        }
    }

}

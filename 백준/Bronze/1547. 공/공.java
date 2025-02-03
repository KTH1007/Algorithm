import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr= new int[3];
        arr[0] = 1;

        StringTokenizer st;
        while (n-- > 0 ) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (arr[a] == 1) {
                arr[a] = 0;
                arr[b] = 1;
            } else if (arr[b] == 1) {
                arr[b] = 0;
                arr[a] = 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (arr[i] == 1) {
                System.out.println(i + 1);
            }
        }
    }
}

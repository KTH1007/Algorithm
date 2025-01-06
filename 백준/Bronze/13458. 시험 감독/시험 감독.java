import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long answer = 0;

        answer += n;
        for (int i = 0; i < n; i++) {
            arr[i] -= b;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                answer += arr[i] / c;
                if (arr[i] % c > 0) answer++;
            }
        }

        System.out.println(answer);

    }

}

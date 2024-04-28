import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int count = 0;
        while (true) {
            answer++;
            count = 0;
            for (int i = 0; i < 5; i++) {
                if (answer >= arr[i] && answer % arr[i] == 0) {
                    count++;
                }
            }
            if (count > 2) break;
        }

        System.out.println(answer);
    }

}

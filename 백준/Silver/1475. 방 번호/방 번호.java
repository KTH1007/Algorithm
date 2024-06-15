import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int[] arr = new int[10];

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (n == 6 || n == 9) {
                int min = Math.min(arr[6], arr[9]);

                if (arr[6] == min) arr[6]++;
                else arr[9]++;
            } else {
                arr[n]++;
            }
        }

        for (int i = 0; i < 10; i++) {
            answer = Math.max(answer, arr[i]);
        }

        System.out.println(answer);
    }


}

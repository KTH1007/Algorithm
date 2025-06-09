import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                arr[c - 'A'] += (int) Math.pow(10, s.length() - 1 - j);
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int seq = 25;
        int answer = 0;


        for (int i = 25; i >= 0; i--) {
            if (arr[seq] != 0) {
                answer += arr[seq--] * num;
                num--;
            }
        }

        System.out.println(answer);
    }

}

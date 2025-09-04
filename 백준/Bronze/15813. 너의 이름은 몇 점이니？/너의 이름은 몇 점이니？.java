import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',  'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String s = br.readLine();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if (c == alphabet[j]) {
                    sum += j + 1;
                }
            }
        }
        System.out.println(sum);
    }
}

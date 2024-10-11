import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }

        int max = Integer.MIN_VALUE;
        char alphabet = 'a';
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                alphabet = (char) (i + 'A');
            } else if (max == arr[i]) {
                alphabet = '?';
            }
        }

        System.out.println(alphabet);
    }
}

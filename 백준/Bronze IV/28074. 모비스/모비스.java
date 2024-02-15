import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] arr = new char[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M' || c == 'O' || c == 'B' || c == 'I' || c == 'S') arr[s.charAt(i) - 'A']++;
        }

        if (arr['M' - 'A'] >= 1 && arr['O' - 'A'] >= 1 && arr['B' - 'A'] >= 1 && arr['I' - 'A'] >= 1 && arr['S' - 'A'] >= 1)
            System.out.println("YES");
        else System.out.println("NO");
    }

}

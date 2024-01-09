import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 97]++;
        }
        StringBuilder sb = new StringBuilder();

        for (int i : alpha) sb.append(i).append(" ");
        System.out.println(sb);
    }


}

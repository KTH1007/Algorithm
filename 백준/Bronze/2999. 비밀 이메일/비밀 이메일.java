import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int r = 0;
        for (int i = 1; i <= Math.sqrt(s.length()); i++) {
            if (s.length() % i == 0) r = i;
        }
        int c = s.length() / r;


        char[][] arr = new char[r][c];
        int count = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                arr[j][i] = s.charAt(count++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(arr[i][j]);
            }
        }

        System.out.println(sb);
    }
}

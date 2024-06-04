import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int zr = Integer.parseInt(st.nextToken());
        int zc = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            String s = "";
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < zc; k++) {
                    s += arr[i][j];
                }
            }
            for (int j = 0; j < zr; j++) {
                sb.append(s).append("\n");
            }
        }

        System.out.println(sb);
    }

}

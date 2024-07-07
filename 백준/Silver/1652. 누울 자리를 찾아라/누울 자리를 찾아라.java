import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int width = 0;
        int length = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 1; j < n; j++) {
                if (arr[i][j - 1] == '.' && arr[i][j] == '.' && flag == true) {
                    width++;
                    flag = false;
                }
                if (arr[i][j] == 'X') {
                    flag = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 1; j < n; j++) {
                if (arr[j - 1][i] == '.' && arr[j][i] == '.' && flag == true) {
                    length++;
                    flag = false;
                }
                if (arr[j][i] == 'X') {
                    flag = true;
                }
            }
        }

        System.out.println(width + " " + length);
        br.close();
    }

}

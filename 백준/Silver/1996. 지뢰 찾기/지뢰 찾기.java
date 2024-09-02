import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int[] dy = {1, 1, 1, 0, 0, 0, -1, -1, -1};

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        char[][] result = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != '.') {
                    result[i][j] = '*';
                } else {
                    int num = 0;
                    for (int k = 0; k < 9; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] != '.') {
                            num += arr[nx][ny] - '0';
                        }
                    }
                    if (num > 9) {
                        result[i][j] = 'M';
                    } else result[i][j] = Integer.toString(num).charAt(0);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];

        st = new StringTokenizer(br.readLine());
        int stCount = st.countTokens();
        int idx = 0;
        while (stCount-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            for (int i = h - 1; i >= h - n; i--) {
                arr[i][idx] = 1;
            }
            idx++;
        }

        int sum = 0;
        for (int i = 0; i < h; i++) {
            int count = 0;
            boolean wall = false;
            for (int j = 0; j < w; j++) {
                if (wall && arr[i][j] == 1) {
                    sum += count;
                    count = 0;
                }
                if (arr[i][j] == 0) count++;
                else {
                    wall = true;
                    count = 0;
                }
            }
        }

        System.out.println(sum);

    }
}

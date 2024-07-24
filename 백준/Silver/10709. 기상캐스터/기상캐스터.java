import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] arr = new int[h][w];

        boolean cloud = false;
        int count = 0;

        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            count = 0;
            cloud = false;
            for (int j = 0; j < w; j++) {
                char c = s.charAt(j);
                if (c == 'c') {
                    cloud = true;
                    count = 1;
                } else if (c == '.' && cloud) {
                    arr[i][j] = count;
                    count++;
                } else if (c == '.' && !cloud) {
                    arr[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}

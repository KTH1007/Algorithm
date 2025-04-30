import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        int[] stores = new int[n + 1];

        // 북쪽 기준으로 좌표 생성
        for (int i = 0; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int way = Integer.parseInt(st.nextToken());
            stores[i] = Integer.parseInt(st.nextToken());

            if (way == 2) { // 남쪽
                stores[i] = w + h + (w - stores[i]);
            } else if (way == 3) { // 서쪽
                stores[i] = 2 * w + h + (h - stores[i]);
            } else if (way == 4) { // 동쪽
                stores[i] += w;
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int sum = Math.abs(stores[n] - stores[i]);
            answer += Math.min(sum, (2 * w + 2 * h) - sum);
        }

        System.out.println(answer);
    }

}

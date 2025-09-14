import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;

        if (k == 1) {
            for (int i = 0; i < n; i++) {
                answer = Math.min(answer, disc(i, i, i));
            }
        } else if (k == 2) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    answer = Math.min(answer, disc(i, i, j));
                }
            }
        } else if (k == 3) {
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int l = j + 1; l < n; l++) {
                        answer = Math.min(answer, disc(i, j, l));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int disc(int a, int b, int c) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int temp1 = Math.abs(arr[i][0] - arr[a][0]) + Math.abs(arr[i][1] - arr[a][1]);
            int temp2 = Math.abs(arr[i][0] - arr[b][0]) + Math.abs(arr[i][1] - arr[b][1]);
            int temp3 = Math.abs(arr[i][0] - arr[c][0]) + Math.abs(arr[i][1] - arr[c][1]);

            answer = Math.max(answer, Math.min(temp1, Math.min(temp2, temp3)));
        }
        return answer;
    }

}

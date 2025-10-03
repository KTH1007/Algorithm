import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = change(st.nextToken()) - 10;
            arr[i][1] = change(st.nextToken()) + 10;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        System.out.println(maxTime(arr));
    }

    private static int change(String num) {
        String temp1 = num.substring(0, 2);
        String temp2 = num.substring(2);

        return Integer.parseInt(temp1) * 60 + Integer.parseInt(temp2);
    }

    private static int maxTime(int[][] arr) {
        int start = 600;
        int end = 1320;
        int max = 0;

        max = Math.max(max, arr[0][0] - start);
        int lastEnd = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] > lastEnd) {
                max = Math.max(max, arr[i][0] - lastEnd);
            }
            lastEnd = Math.max(lastEnd, arr[i][1]);
        }

        max = Math.max(max, end - lastEnd);

        return max;
    }
}

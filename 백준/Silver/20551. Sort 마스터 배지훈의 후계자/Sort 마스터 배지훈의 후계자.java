import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int findIndex = binarySearch(num, arr);
            sb.append(findIndex).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int key, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                answer = mid;
                right = mid - 1;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

}

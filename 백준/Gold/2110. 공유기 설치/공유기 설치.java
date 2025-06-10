import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        Arrays.sort(arr);
        int left = 1;
        int right = arr[n - 1] - arr[0];

        int answer = binarySearch(left, right);
        System.out.println(answer);
    }

    private static int binarySearch(int left, int right) {
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = canInstall(mid);
            
            if (count >= c) {
                answer = mid;  // 가능한 경우이므로 답 갱신
                left = mid + 1;  // 더 큰 거리로 시도
            } else {
                right = mid - 1;  // 더 작은 거리로 시도
            }
        }

        return answer;
    }

    private static int canInstall(int distance) {
        int count = 1;  // 첫 번째 집에 공유기 설치
        int lastInstalled = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = arr[i];
            }
        }

        return count;
    }
}

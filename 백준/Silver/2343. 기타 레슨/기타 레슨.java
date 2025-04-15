import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] lesson = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
        }

        // 1 ~ 9분의 강의가 있을 때 M이 1인 경우는 값이 9, M이 10인 경우 값이 45가 나올 수 있다.
        int sum = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            sum += lesson[i];
            left = Math.max(left, lesson[i]);
        }
        int right = sum;

        System.out.println(binarySearch(left, right, lesson));
    }

    private static int binarySearch(int left, int right, int[] lesson) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {
                if (sum + lesson[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += lesson[i];
            }

            if (count <= m) { // count가 낮으면 값이 높게 설정 되어 있는 것임
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

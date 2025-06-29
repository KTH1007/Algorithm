import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[4];

        for (int i = 0; i < 4; i++) {
            arr[i] = br.readLine();
        }

        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            rotation(arr, n, m);
        }

        int count = 0;
        int mul = 1;
        for (int i = 1; i <= 4; i++) {
            if (arr[i - 1].charAt(0) == '1') {
                count += mul;
            }
            mul *= 2;
        }

        System.out.println(count);
    }

    private static void rotation(String[] arr, int n, int m) {
        // 오른쪽 인덱스 2, 왼쪽 인덱스 6
        int[] rotateDir = new int[4];

        rotateDir[n - 1] = m;

        // 왼쪽으로 전파
        for (int i = n - 1; i > 0; i--) {
            if (arr[i].charAt(6) != arr[i - 1].charAt(2)) {
                rotateDir[i - 1] = -rotateDir[i];
            } else {
                break;
            }
        }

        // 오른쪽으로 전파
        for (int i = n - 1; i < 3; i++) {
            if (arr[i].charAt(2) != arr[i + 1].charAt(6)) {
                rotateDir[i + 1] = -rotateDir[i];
            } else {
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (rotateDir[i] == 1) {
                arr[i] = arr[i].charAt(7) + arr[i].substring(0, 7);
            } else if (rotateDir[i] == -1) { // 반시계방향
                arr[i] = arr[i].substring(1) + arr[i].charAt(0);
            }
        }
    }
}

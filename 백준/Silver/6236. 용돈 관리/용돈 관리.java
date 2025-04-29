import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        int max = 0; // 하루 지출 최댓값
        int sum = 0; // 총 지출

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            max = Math.max(max, num);
            sum += num;
        }

        int left = max;
        int right = sum;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int currentMoney = mid;

            for (int i = 0; i < n; i++) {
                if (currentMoney < arr[i]) {
                    currentMoney = mid;
                    count++;

                    if (currentMoney < arr[i]) {
                        count = m + 1;
                    }
                }

                currentMoney -= arr[i];
            }

            if (count > m) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);
    }

}

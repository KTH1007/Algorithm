import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int[] arr = new int[n];

        StringTokenizer st;
        int count = 0;
        while (count < n) {
            int[] num = new int[5];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 5; j++) {
                    for (int k = j + 1; k < 5; k++) {
                        int temp = (num[i] + num[j] + num[k]) % 10;
                        max = Math.max(max, temp);
                        arr[count] = Math.max(arr[count], temp);
                    }
                }
            }
            count++;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (max == arr[i]) {
                System.out.println(i + 1);
                break;
            }
        }
        br.close();
    }
}

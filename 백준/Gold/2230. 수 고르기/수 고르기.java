import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int i = 0, j = 0;
        while (i < n) {
            int temp = arr[i] - arr[j];
            if (temp < m) {
                i++;
                continue;
            }
            if (temp == m) {
                answer = temp;
                break;
            }
            answer = Math.min(answer, temp);
            j++;
        }
        System.out.println(answer);
    }


}
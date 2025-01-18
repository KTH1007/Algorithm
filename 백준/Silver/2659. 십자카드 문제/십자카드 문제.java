import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int clockNum = getClockNum(arr);
        int result = findSmallClockNum(clockNum);

        System.out.println(result);

    }

    private static int getClockNum(int[] arr) {
        int num = 10000;
        StringBuilder sb;

        for (int i = 0; i < 4; i++) {
            sb = new StringBuilder();

            for (int j = 0; j < 4; j++) {
                sb.append(arr[(i + j) % 4]);
            }

            num = Math.min(num, Integer.parseInt(sb.toString()));
        }

        return num;
    }

    private static int findSmallClockNum(int clockNum) {
        int answer = 0;

        for (int i = 1111; i <= clockNum; i++) {
            if (String.valueOf(i).contains("0")) continue;

            int[] digit = new int[4];
            int k = i;
            for (int j = 3; j >= 0; j--) {
                digit[j] = k % 10;
                k /= 10;
            }

            if (getClockNum(digit) == i) answer++;
        }

        return answer;
    }
}

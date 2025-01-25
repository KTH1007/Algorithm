import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        String s = br.readLine();

        int start = 0;
        int last = s.length() - 1;

        int[] arr = new int[s.length()];
        Arrays.fill(arr, -1);

        int oneCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num == 1) oneCount++;
            else zeroCount++;
            arr[i] = num;
        }

        if (oneCount % 2 != 0) {
            oneCount = oneCount / 2 + 1;
        } else oneCount /= 2;

        if (zeroCount % 2 != 0) {
            zeroCount = zeroCount / 2 + 1;
        } else zeroCount /= 2;

        while (oneCount > 0 || zeroCount > 0 && (start < s.length() - 1 && last >= 0)) {
            if (arr[start] == 1 && oneCount > 0) {
                arr[start] = 2;
                oneCount--;
            }
            if (arr[last] == 0 && zeroCount > 0) {
                arr[last] = 2;
                zeroCount--;
            }

            start++;
            last--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            if (i == 0 || i == 1) {
                sb.append(i);
            }
        }

        System.out.println(sb);
    }
}

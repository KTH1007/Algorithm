import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int aCount = Integer.parseInt(st.nextToken());
            Integer[] aArr = new Integer[aCount];
            arr(aArr, st);

            st = new StringTokenizer(br.readLine());
            int bCount = Integer.parseInt(st.nextToken());
            Integer[] bArr = new Integer[bCount];
            arr(bArr, st);

            compare(aArr, bArr, sb);
        }

        System.out.println(sb);
    }

    public static void arr(Integer[] arr, StringTokenizer st) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
    }

    public static void compare(Integer[] aArr, Integer[] bArr, StringBuilder sb) {
        int min = Math.min(aArr.length, bArr.length);

        for (int i = 0; i < min; i++) {
            if (aArr[i] > bArr[i]) {
                sb.append("A").append("\n");
                return;
            } else if (aArr[i] < bArr[i]) {
                sb.append("B").append("\n");
                return;
            }
        }

        if (aArr.length == bArr.length) {
            sb.append("D").append("\n");
        } else {
            if (aArr.length > bArr.length) {
                sb.append("A").append("\n");
            } else {
                sb.append("B").append("\n");
            }
        }
    }
}

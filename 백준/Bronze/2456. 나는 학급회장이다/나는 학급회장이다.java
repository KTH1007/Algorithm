import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] maxArr = new int[3];
        int[] powArr = new int[3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());

            maxArr[0] += temp;
            powArr[0] += (int) Math.pow(temp, 2);

            temp = Integer.parseInt(st.nextToken());
            maxArr[1] += temp;
            powArr[1] += (int) Math.pow(temp, 2);

            temp = Integer.parseInt(st.nextToken());
            maxArr[2] += temp;
            powArr[2] += (int) Math.pow(temp, 2);
        }


        int max = Math.max(maxArr[0], Math.max(maxArr[1], maxArr[2]));

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (maxArr[i] == max) count++;
        }

        if (count == 1) {
            for (int i = 0; i < 3; i++) {
                if (maxArr[i] == max) System.out.println(i + 1 + " " + maxArr[i]);
            }
        } else {
            int powMax = Math.max(powArr[0], Math.max(powArr[1], powArr[2]));

            int powCount = 0;
            for (int i = 0; i < 3; i++) {
                if (powArr[i] == powMax) powCount++;
            }

            if (powCount > 1) {
                System.out.println(0 + " " + max);
            } else {
                for (int i = 0; i < 3; i++) {
                    if (powArr[i] == powMax) System.out.println(i + 1 + " " + maxArr[i]);
                }
            }
        }
    }
}

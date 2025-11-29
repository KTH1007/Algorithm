import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");

        int[] honey = new int[n];
        for (int i = 0; i < n; i++) {
            honey[i] = Integer.parseInt(tokens[i]);
        }

        int[] leftToRightSum = new int[n];
        int[] rightToLeftSum = new int[n];

        leftToRightSum[0] = honey[0];
        for (int i = 1; i < n; i++) {
            leftToRightSum[i] = leftToRightSum[i - 1] + honey[i];
        }

        rightToLeftSum[n - 1] = honey[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightToLeftSum[i] = rightToLeftSum[i + 1] + honey[i];
        }

        int max = 0;

        /**
         * 벌 벌 꿀
         * 꿀벌 하나는 0에 위치, 2번 꿀벌 위치만 바꾸면 됨
         **/
        for (int i = 1; i < n - 1; i++) {
            int total = (leftToRightSum[n - 1] - honey[0] - honey[i]) + (leftToRightSum[n - 1] - leftToRightSum[i]);
            max = Math.max(max, total);
        }

        /**
         * 꿀 벌 벌
         * 벌 하나는 오른쪽 끝
         * 2번 꿀벌 위치만 조정
         */
        for (int i = n - 2; i >= 1; i--) {
            int total = (rightToLeftSum[0] - honey[n - 1] - honey[i]) + (rightToLeftSum[0] - rightToLeftSum[i]);
            max = Math.max(max, total);
        }

        /**
         * 벌 꿀 벌
         * 벌 위치는 각각 왼쪽 끝, 오른쪽 끝에 위치
         */
        for (int i = 1; i < n - 1; i++) {
            int total = (leftToRightSum[i] - honey[0]) + (rightToLeftSum[i] - honey[n - 1]);
            max = Math.max(max, total);
        }

        System.out.println(max);
    }
}

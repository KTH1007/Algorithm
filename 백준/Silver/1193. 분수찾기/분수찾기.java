import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /** 대각선으로 묶었을 떄 분수 분모의 합 - 1이 대각선 안의 분수의 개수
         *  t가 홀수일 때 위부터 시작
         *  t가 짝수일 때 아래부터 시작
         */
        int n = Integer.parseInt(br.readLine());
        //대각선 칸의 개수
        int crossCount = 1;
        //해당 대각선 직전 대각선까지 칸의 누적 합
        int previousCountSum = 0;

        while (true) {
            if (n <= previousCountSum + crossCount) {
                if (crossCount % 2 == 1) {
                    // 분자가 큰 수부터 시작
                    // 분자 n번째 - 직전 대각선까지의 블럭 개수 - 1
                    // 분모 n번째 - 직전 대각선까지의 블럭 개수
                    System.out.println((crossCount - (n - previousCountSum - 1)) + "/" + (n - previousCountSum));
                    break;
                } else {
                    // 짝수의 경우 홀수 출력의 반대로
                    System.out.println((n - previousCountSum) + "/" + (crossCount - (n - previousCountSum - 1)));
                    break;
                }
            } else {
                previousCountSum += crossCount;
                crossCount++;
            }
        }

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 현재 대각선 블록 개수
        int crossCount = 1;
        // 직전 대각선까지의 블럭 개수
        int previousCountSum = 0;

        while (true) {
            if (n <= previousCountSum + crossCount) {
                if (crossCount % 2 == 1) { //대각선 개수가 홀수면 왼쪽 아래에서 오른쪽 위로 올라옴 즉 분자가 큰 수부터
                    System.out.println(crossCount - (n - previousCountSum - 1) + "/" + (n - previousCountSum));
                    break;
                } else {
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

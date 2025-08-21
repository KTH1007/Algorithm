import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 입력 받기
            String tmp = br.readLine();

            // 종료 조건
            if (tmp.equals("0")) {
                break;
            }

            String[] num = tmp.split("");

            // 계산 하기
            testNum(num);
        }
    }

    // 재귀함수 형식으로 구현
    static void testNum(String[] num) {
        int rslt = 0;
        for (int i = 0; i < num.length; i++) {
            rslt += Integer.parseInt(num[i]);
        }

        // 10으로 나눠서 몫이 0이면 한 자릿수라고 판단함.
        if((rslt / 10) == 0) {
            // 결과가 나왔으므로 출력
            System.out.println(rslt);
        } else {
            // 아직 한 자릿수가 되지 않았을 경우 재귀 호출.
            testNum(String.valueOf(rslt).split(""));
        }
    }
}
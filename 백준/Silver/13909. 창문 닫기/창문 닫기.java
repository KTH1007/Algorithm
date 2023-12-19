import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // n 번째 창문이 열려 있으려면 n의 약수의 개수가 홀수개
        // 약수의 개수가 홀수가 되려면 제곱수여야 함 1 4 9 16 25

        int count = 0;

        for (int i = 1; i * i <= n; i++) count++;

        System.out.println(count);

    }


}



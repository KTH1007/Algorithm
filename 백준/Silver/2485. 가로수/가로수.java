import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        int diff = 0;
        int gcd = 0;

        for (int i = 0; i < n - 1; i++) {
            diff = arr[i + 1] - arr[i];
            gcd = GCD(gcd, diff);  // 가로수 간격의 최대 공약수를 저장
        }

        //(arr[n-1] - arr[0]) / gcd -> 간격의 수
        //간격의 수에 1을 더해야 가로수 총 개수l
        //원래 가로수 개수를 빼줘야 함
        System.out.println((arr[n - 1] - arr[0]) / gcd + 1 - n);
    }

    static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}

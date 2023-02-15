import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        while (true){
            if(n % 5 == 0){
                count += n/5;
                break;
            }
            else {
                n -= 3;
                count++;  // 5로 안 나눠지면 3킬로그램 봉지 하나 추가
            }
            if(n<0){
                count = -1;
                break;
            }
        }
        System.out.println(count);


    }
}
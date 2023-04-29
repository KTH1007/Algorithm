import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        String s = st.nextToken();
        int sum = Integer.MAX_VALUE;
        String[] sarr = s.split("-");
        for(int i=0; i<sarr.length; i++){
            String[] plus = sarr[i].split("\\+");
            int temp = 0;
            for(int j=0; j<plus.length; j++){
                temp += Integer.parseInt(plus[j]);
            }
            if(sum == Integer.MAX_VALUE){ //첫 번째 배열은 무조건 양수이기 때문에 sum에 대입해줌
                sum = temp;
            }
            else sum -= temp;
        }
        System.out.println(sum);
    }
}

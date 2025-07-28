import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while ((str = br.readLine()) != null && !str.isEmpty()){
            StringTokenizer st = new StringTokenizer(str);
            int coupon = Integer.parseInt(st.nextToken());
            int stamp = Integer.parseInt(st.nextToken());
            int couponPlus = coupon;
            int answer = coupon;

            while (couponPlus >= stamp){
                answer += couponPlus / stamp;
                couponPlus = (couponPlus/stamp) + (couponPlus % stamp);
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
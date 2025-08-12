import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int yang = Integer.parseInt(st.nextToken());
        int fried = Integer.parseInt(st.nextToken());
        int half = Integer.parseInt(st.nextToken());
        int doubleHalf = half * 2;
        int plzYang = Integer.parseInt(st.nextToken());
        int plzFried = Integer.parseInt(st.nextToken());

        int basic = (yang * plzYang) + (fried * plzFried);
        int halfCount = 0;
        int answer = 0;

        int min = Math.min(plzFried, plzYang);

        if (min == plzFried) {
            if (doubleHalf < yang) {
                halfCount = (half * plzFried) * 2 + ((plzYang - min) * half * 2);
            } else {
                halfCount = (half * plzFried) * 2 + (plzYang - min) * yang;
            }
        } else {
            if (doubleHalf < fried) {
                halfCount = (half * plzYang) * 2 + ((plzFried - min) * half * 2);
            } else {
                halfCount = (half * plzYang) * 2 + (plzFried - min) * fried;
            }
        }

        answer = Math.min(basic, halfCount);

        sb.append(answer);
        System.out.println(sb.toString());
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // c가 포함되어 있지 않고 k개 연속으로 먹는 경우가 최대
        
        Set<Integer> answer = new HashSet<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            answer = new HashSet<>();
            answer.add(c);
            for (int j = 0; j < k; j++) {
                int num = i + j;
                if (num >= n) num %= n;
                answer.add(list.get(num));
            }
            max = Math.max(max, answer.size());
        }

        System.out.println(max);
    }

}

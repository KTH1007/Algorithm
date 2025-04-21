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
        
        Map<Integer, Integer> answer = new HashMap<>();
        int max = 0;

        int left = 0;
        int right = k - 1;

        for (int i = 0; i < k; i++) {
            answer.put(list.get(i), answer.getOrDefault(list.get(i), 0) + 1);
        }
        answer.put(c, answer.getOrDefault(c, 0) + 1);

        while (left < n) {
            answer.put(list.get(left), answer.get(list.get(left)) - 1);
            if (answer.get(list.get(left)) == 0) answer.remove(list.get(left));
            left++;
            right++;
            if (right >= n) right %= n;
            answer.put(list.get(right), answer.getOrDefault(list.get(right), 0) + 1);

            max = Math.max(max, answer.size());
            if (max == k + 1) break;
        }

        System.out.println(max);
    }

}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'X') {
                count++;
            } else {
                if (count != 0) {
                    if (count % 2 == 0) {
                        sb.append("AAAA".repeat(count / 4));
                        sb.append("BB".repeat((count % 4) / 2));
                    } else {
                        System.out.println(-1);
                        return;
                    }
                    count = 0;
                }
                sb.append(c);
            }
        }
        // 마지막 남은 X들 처리
        if (count != 0) {
            if (count % 2 == 0) {
                sb.append("AAAA".repeat(count / 4));
                sb.append("BB".repeat((count % 4) / 2));
            } else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}

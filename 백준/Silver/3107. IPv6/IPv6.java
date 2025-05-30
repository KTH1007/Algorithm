import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if(str.contains("::")) {
            str = str.replace("::",":zeros:");
        }

        String[] split = str.split(":");

        List<String> input = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            input.add(split[i]);
        }

        for (int i = 0; i < input.size(); i++) {
            String next = input.get(i);

            if (next.isEmpty()) continue;
            if (next.length() < 4) {
                String temp = "0".repeat(4 - next.length());
                next = temp + next;
            }

            answer.add(next);
        }

        String[] ip = new String[8];
        int zero = 8 - answer.size() + 1;
        int idx = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals("zeros")) {
                while (zero-- > 0) {
                    ip[idx++] = "0000";
                }
            } else {
                ip[idx++] = answer.get(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(ip[i]).append(":");
        }
        sb.append(ip[7]);

        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] num = new String[n];

        for (int i = 0; i < n; i++) {
            num[i] = br.readLine();
        }

        int count = 1;
        List<String> list = new ArrayList<>();
        int len = num[0].length();

        while (list.size() != n) {
            for (String s : num) {
                String sub = s.substring(len - count, len);
                if (list.contains(sub)) {
                    list = new ArrayList<>();
                    count++;
                    break;
                } else {
                    list.add(sub);
                }
            }
        }
        System.out.println(count);
    }

}

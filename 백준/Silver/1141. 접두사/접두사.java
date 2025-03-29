import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        list.sort((o1, o2) -> o2.length() - o1.length());

        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean isPrefix = false;
            for (int j = 0; j < i; j++) {
                if (list.get(j).startsWith(list.get(i))) {
                    isPrefix = true;
                    break;
                }
            }
            if (!isPrefix) count++;
        }

        System.out.println(count);
    }
}

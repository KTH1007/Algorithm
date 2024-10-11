import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i, s.length()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        list.stream().forEach(i -> sb.append(i).append("\n"));
        System.out.println(sb);
    }
}

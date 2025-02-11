import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort((o1, o2) -> o2 - o1);

        int score = 0;
        while (list.size() != 1) {
            score += list.get(0) * list.get(1);
            list.add(list.get(0) + list.get(1));
            list.remove(0);
            list.remove(0);

            list.sort((o1, o2) -> o2 - o1);
        }

        System.out.println(score);
    }

}

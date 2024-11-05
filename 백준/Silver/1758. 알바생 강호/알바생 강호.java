import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        while (n-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, (o1, o2) -> o2 - o1);

        long tip = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) - i < 0) {
                break;
            }
            tip += list.get(i) - i;
        }

        System.out.println(tip);
    }
}

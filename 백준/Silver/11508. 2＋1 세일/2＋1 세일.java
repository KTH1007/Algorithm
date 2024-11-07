import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        while (n-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort((o1, o2) -> o2 - o1);

        int cost = 0;

        while (list.size() >= 3) {
            cost += list.get(0) + list.get(1);
            list.remove(0);
            list.remove(0);
            list.remove(0);
        }

        if (list.size() > 0) {
            for (int i : list) {
                cost += i;
            }
        }

        System.out.println(cost);
    }
}

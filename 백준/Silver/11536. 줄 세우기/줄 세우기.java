import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(list.get(i));
        }

        Collections.sort(list);

        if (check(list, temp, n)) {
            System.out.println("INCREASING");
            return;
        }

        Collections.sort(list, Collections.reverseOrder());

        if (check(list, temp, n)) {
            System.out.println("DECREASING");
            return;
        } else System.out.println("NEITHER");


        br.close();
    }

    static boolean check(List<String> list, List<String> temp, int n) {
        for (int i = 0; i < n; i++) {
            if (!list.get(i).equals(temp.get(i))) {
                return false;
            }
        }
        return true;
    }


}

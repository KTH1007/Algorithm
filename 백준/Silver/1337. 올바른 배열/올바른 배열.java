import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        while (n-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(null);

        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (!list.contains(list.get(i) + j)) {
                    count++;
                }
            }
            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new LinkedList<>();
        int i = 2;
        while (n > 0) {
            if (i > n) break;
            if (n % i == 0) {
                list.add(i);
                n /= i;
            } else {
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer).append("\n");
        }

        System.out.println(sb);
    }
}

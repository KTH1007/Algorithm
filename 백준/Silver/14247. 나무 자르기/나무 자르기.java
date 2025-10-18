import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr1 = new long[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] arr2 = new long[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = Long.parseLong(st.nextToken());
        }

        List<long[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new long[]{arr1[i], arr2[i]});
        }

        list.sort((o1, o2) ->Long.compare(o1[1], o2[1]));

        List<Long> trees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            trees.add(list.get(i)[0] + (list.get(i)[1] * i));
        }

        long sum = 0;
        for (Long tree : trees) {
            sum += tree;
        }

        System.out.println(sum);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = st.countTokens();
        arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }

        search(0, size - 1, 0);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void search(int start, int end, int depth) {
        if (depth == k) {
            return;
        }

        int mid = (start + end) / 2;

        list.get(depth).add(arr[mid]);

        search(start, mid - 1, depth + 1);
        search(mid + 1, end, depth + 1);

    }
}

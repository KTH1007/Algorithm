import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n, m;
    static boolean[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] children = new int[n];

        for (int i = 0; i < n; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> list = new ArrayList<>();

        for (int child : children) {
            int position = binarySearch(list, child);

            if (position == list.size()) {
                list.add(child);
            } else {
                list.set(position, child);
            }
        }


        System.out.println(n - list.size());
    }

    private static int binarySearch(List<Integer> list, int num) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

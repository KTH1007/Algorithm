import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        int[] dpInc = new int[n];
        List<Integer> lisInc = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int position = binarySearch(lisInc, arr[i]);

            if (position == lisInc.size()) {
                lisInc.add(arr[i]);
            } else {
                lisInc.set(position, arr[i]);
            }

            dpInc[i] = lisInc.size();
        }

        int[] dpDec = new int[n];
        List<Integer> lisDec = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            int position = binarySearch(lisDec, arr[i]);

            if (position == lisDec.size()) {
                lisDec.add(arr[i]);
            } else {
                lisDec.set(position, arr[i]);
            }

            dpDec[i] = lisDec.size();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dpInc[i] + dpDec[i] - 1);
        }

        System.out.println(max);
    }

    private static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

        List<Integer> lis = new ArrayList<>();
        int[] lisIdx = new int[n];

        for (int i = 0; i < n; i++) {
            int position = binarySearch(lis, arr[i]);

            if (position == lis.size()) {
                lis.add(arr[i]);
            } else {
                lis.set(position, arr[i]);
            }

            lisIdx[i] = position;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis.size()).append("\n");

        int targetLen = lis.size() - 1;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            if (lisIdx[i] == targetLen) {
                stack.push(arr[i]);
                targetLen--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);

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

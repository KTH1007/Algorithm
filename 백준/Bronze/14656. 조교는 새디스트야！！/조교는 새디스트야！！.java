import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] != i + 1)
                ++cnt;
        }

        System.out.println(cnt);
    }
}
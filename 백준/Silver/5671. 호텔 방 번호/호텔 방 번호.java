import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = func(n, m);
            sb.append(count).append("\n");

        }

        System.out.println(sb);

    }

    private static int func(int n, int m) {
        int count = 0;
        for (int i = n; i <= m; i++) {
            int[] arr = new int[10];
            boolean flag = true;

            String s = Integer.toString(i);
            for (int j = 0; j < s.length(); j++) {
                int num = s.charAt(j) - '0';
                if (arr[num] != 0) {
                    flag = false;
                    break;
                }
                arr[num]++;
            }

            if (flag) count++;
        }
        return count;
    }

}

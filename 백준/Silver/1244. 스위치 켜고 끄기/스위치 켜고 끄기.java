import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int state[] = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                for (int i = 1; i <= n; i++) {
                    if (i % num == 0) {
                        change(state, i);
                    }
                }
            } else if (sex == 2) {
                change(state, num);
                int left = num - 1;
                int right = num + 1;

                while (left >= 1 && right <= n) {
                    if (state[left] == state[right]) {
                        change(state, left);
                        change(state, right);
                    } else {
                        break;
                    }
                    left--;
                    right++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(state[i]).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    static void change(int[] state, int num) {
        if (state[num] == 0) state[num] = 1;
        else state[num] = 0;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] breakage = new int[s];
        int[] redundancy = new int[r];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            breakage[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            redundancy[i] = Integer.parseInt(st.nextToken());
        }

        int count = s;

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < r; j++) {
                if (count > 0) {
                    if (breakage[i] == redundancy[j]) {
                        count--;
                        redundancy[j] = -1;
                        breakage[i] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < r; j++) {
                if (count > 0) {
                    if (breakage[i] == redundancy[j] - 1 || breakage[i] == redundancy[j] + 1) {
                        count--;
                        redundancy[j] = -1;
                        breakage[i] = -1;
                    }
                }
            }
        }

        System.out.println(count);
    }

}

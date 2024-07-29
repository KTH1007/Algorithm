import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        int maxStudent = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> sameClass = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[i][j] == arr[k][j] && k != i) {
                        sameClass.add(k);
                    }
                }
            }
            if (maxStudent < sameClass.size()) {
                maxStudent = sameClass.size();
                answer = i;
            }
        }

        System.out.println(answer + 1);
        br.close();
    }

}

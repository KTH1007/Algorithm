import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][3];

        double sum = 0;
        double haksum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double temp = 0;
            for (int j = 0; j < 3; j++) {
                arr[i][j] = st.nextToken();
            }
            String score = arr[i][2];
            if (score.charAt(0) == 'A') temp = 4;
            else if (score.charAt(0) == 'B') temp = 3;
            else if (score.charAt(0) == 'C') temp = 2;
            else if (score.charAt(0) == 'D') temp = 1;
            if (score.charAt(0) != 'F' && score.charAt(1) == '+') temp += 0.3;
            if (score.charAt(0) != 'F' && score.charAt(1) == '-') temp -= 0.3;

            sum += Integer.parseInt(arr[i][1]) * temp;
            haksum += Integer.parseInt(arr[i][1]);
        }

        System.out.printf("%.2f", sum / haksum);
    }
}

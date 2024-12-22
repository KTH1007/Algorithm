import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                for (int j = -k; j <= k; j++) {
                    int idx = i + j;
                    if (idx >= 0 && idx < n && arr[idx] == 'H') {
                        count++;
                        arr[idx] = 'N';
                        break;
                    }
                }
            }
        }

        System.out.println(count);

    }

}

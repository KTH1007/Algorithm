import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int currentLocation = 1;
        int count = 0;

        for (int i = 0; i < j; i++) {
            int location = Integer.parseInt(br.readLine());

            if (location == currentLocation) continue;
            if (location > currentLocation) {
                while (location > (m - 1) + currentLocation) {
                    currentLocation++;
                    count++;
                }
            } else {
                while (location < currentLocation) {
                    currentLocation--;
                    count++;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}

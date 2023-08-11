import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[31];
        for (int i = 1; i <= 28; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n]++;
        }
        for (int i = 1; i <= 30; i++) {
            if (arr[i] == 0) System.out.println(i);
        }
    }


}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        String temp = "";
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            temp = sb.append(arr[i]).reverse().toString();
            for (int j = 0; j < n; j++) {
                if (temp.equals(arr[j])) {
                    System.out.print(temp.length() + " " + temp.charAt(temp.length() / 2));
                    return;
                }
            }
        }


    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = {"C", "A", "M", "B", "R", "I", "D", "G", "E"};

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (s.charAt(i) == arr[j].charAt(0)) {
                    flag = true;
                }
            }
            if (!flag) sb.append(s.charAt(i));
        }

        System.out.println(sb);
    }
}

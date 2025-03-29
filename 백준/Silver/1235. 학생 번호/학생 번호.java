import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] studentNumbers = new String[n];
        for (int i = 0; i < n; i++) {
            studentNumbers[i] = br.readLine();
        }

        int k = 1;

        while (true) {
            boolean isCompare = false;

            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String subNumber = studentNumbers[i].substring(studentNumbers[0].length() - k);
                if (set.contains(subNumber)) {
                    isCompare = true;
                    k++;
                    break;
                } else {
                    set.add(subNumber);
                }
            }

            if (!isCompare) break;
        }

        System.out.println(k);
    }
}

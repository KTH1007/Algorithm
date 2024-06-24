import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int count = 0;
        while (document.length() >= word.length()) {
            int index = document.indexOf(word, 0);

            if (index == -1) break;
            count++;
            document = document.substring(index + word.length());
        }

        System.out.println(count);

    }
}

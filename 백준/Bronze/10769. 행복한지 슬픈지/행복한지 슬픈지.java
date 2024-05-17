import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        s = s.toLowerCase().replace(":-)", "H").replace(":-(", "S");

        int happyCount = 0;
        int sadCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'H') happyCount++;
            if (c == 'S') sadCount++;
        }

        if (happyCount == 0 && sadCount == 0) System.out.println("none");
        else if (happyCount != 0 && happyCount == sadCount) System.out.println("unsure");
        else if (happyCount > sadCount) System.out.println("happy");
        else System.out.println("sad");


    }
}

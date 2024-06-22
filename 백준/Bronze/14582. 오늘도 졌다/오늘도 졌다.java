import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] teamA = br.readLine().split(" ");
        String[] teamB = br.readLine().split(" ");

        int score = 0;
        for (int i = 0; i < teamA.length; i++) {
            score += Integer.parseInt(teamA[i]);
            if (score > 0) {
                System.out.println("Yes");
                return;
            }
            score -= Integer.parseInt(teamB[i]);
        }
        System.out.println("No");
    }

}

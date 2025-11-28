import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int numberOfVotes = Integer.parseInt(br.readLine());
        String voteResult = br.readLine();

        int countA = 0;
        for (char result : voteResult.toCharArray()) {
            if (result == 'A') {
                countA++;
            }
        }

        String output = "Tie";
        if (numberOfVotes < countA * 2) {
            output = "A";
        } else if (numberOfVotes > countA * 2) {
            output = "B";
        }

        System.out.print(output);
    }
}

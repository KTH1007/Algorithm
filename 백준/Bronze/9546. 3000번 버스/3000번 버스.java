import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int answer = 1;

            int number = Integer.parseInt(br.readLine());

            for (int j = 1; j < number; j++) {
                answer = (answer * 2) + 1;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
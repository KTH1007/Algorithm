import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        final int nickNameCnt = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nickNameCnt; i++) {
            String[] inputStr = br.readLine().split(" ");
            final int inputStrLength = inputStr.length;
            for (int j = 2; j < inputStrLength; j++) {
                sb.append(inputStr[j]).append(" ");
            }
            sb.append(inputStr[0]).append(" ").append(inputStr[1]);
            sb.append("\n");
        }
        
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}
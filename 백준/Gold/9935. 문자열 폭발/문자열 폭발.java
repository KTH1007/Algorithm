import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String boom = br.readLine();

        String result = removeBoom(s, boom);
        
        if (result.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(result);
        }
    }
    
    private static String removeBoom(String s, String boom) {
        StringBuilder sb = new StringBuilder();
        int boomLen = boom.length();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (sb.length() >= boomLen) {
                boolean isBoom = true;

                for (int j = 0; j < boomLen; j++) {
                    if (sb.charAt(sb.length() - boomLen + j) != boom.charAt(j)) {
                        isBoom = false;
                        break;
                    }
                }

                if (isBoom) {
                    sb.setLength(sb.length() - boomLen);
                }
            }
        }
        return sb.toString();
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("END")) break;
            temp.append(s).reverse();
            sb.append(temp).append("\n");
            temp.setLength(0);
        }
        System.out.println(sb);
    }


}

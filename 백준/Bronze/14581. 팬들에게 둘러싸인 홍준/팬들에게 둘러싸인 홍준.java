import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        sb.append(":fan::fan::fan:").append("\n").append(":fan:")
                .append(":").append(s).append(":").append(":fan:").append("\n")
                .append(":fan::fan::fan:");
        System.out.println(sb);
    }


}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken(), b = st.nextToken();

            sb.append("Distances: ");
            for (int i = 0; i < a.length(); i++) sb.append(dist(a.charAt(i), b.charAt(i))).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int dist(char a, char b) {
        return a <= b ? b - a : b + 26 - a;
    }

}
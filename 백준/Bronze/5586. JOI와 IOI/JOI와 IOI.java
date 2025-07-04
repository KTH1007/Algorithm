import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int a = 0, b = 0;
        for (int i = 3; i <= s.length(); i++) {
            String sub = s.substring(i - 3, i);
            if (sub.equals("JOI")) a++;
            else if (sub.equals("IOI")) b++;
        }

        bw.write(a + "\n" + b);
        bw.flush();
    }

}
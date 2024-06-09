import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, m, i;
        String str1, str2;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        str1 = str2 = "";
        for (i = 0; i < n; i++) str1 = str1 + br.readLine();
        for (i = 0; i < n; i++) str2 = str2 + br.readLine();
        boolean chk = false;
        for (i = 0; i < n * m * 2; i++)
            if (str2.charAt(i) != str1.charAt(i / 2)) {
                chk = true;
                break;
            }
        System.out.println(chk ? "Not Eyfa" : "Eyfa");
    }

}

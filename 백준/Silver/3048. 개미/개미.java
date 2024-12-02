import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        char[] ant = new char[n1 + n2];
        int[] check = new int[n1 + n2];

        String s = br.readLine();
        for (int i = 0; i < n1; i++) {
            ant[i] = s.charAt(n1 - i - 1);
            check[i] = 1;
        }

        s = br.readLine();
        for (int i = n1; i < n1 + n2; i++) {
            ant[i] = s.charAt(i - n1);
            check[i] = 2;
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            for (int i = 0; i < n1 + n2 - 1; i++) {
                if (check[i] == 1 && check[i + 1] == 2) {
                    char tempAnt = ant[i];
                    ant[i] = ant[i + 1];
                    ant[i + 1] = tempAnt;

                    int tempNum = check[i];
                    check[i] = check[i + 1];
                    check[i + 1] = tempNum;

                    i++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1 + n2; i++) {
            sb.append(ant[i]);
        }

        System.out.println(sb);
    }

}

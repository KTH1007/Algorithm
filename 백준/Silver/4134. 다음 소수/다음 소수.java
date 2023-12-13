import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean flag = false;
    static long n = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Long.parseLong(br.readLine());
            if (n <= 2) sb.append(2).append("\n");
            else {
                while (true) {
                    flag = false;
                    long temp = Prime(n);
                    if (flag && temp >= n) {
                        sb.append(temp).append("\n");
                        break;
                    }
                    n++;
                }
            }
        }

        System.out.println(sb);
    }

    static long Prime(long a) {
        for (long i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                flag = false;
                return -1;
            }
        }
        flag = true;
        return a;
    }


}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<BigInteger> list = new ArrayList<>();
        while (n-- > 0) {
            homework(br.readLine(), list);
        }
        sortAndPrint(list);
    }

    private static void sortAndPrint(List<BigInteger> list) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for (BigInteger i : list) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    private static void homework(String s, List<BigInteger> list) {
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (num.length() > 0) {
                    list.add(new BigInteger(num.toString()));
                    num.setLength(0);
                }
            } else {
                num.append(c);
            }
        }
        if (num.length() > 0) {
            list.add(new BigInteger(num.toString()));
        }
    }
}

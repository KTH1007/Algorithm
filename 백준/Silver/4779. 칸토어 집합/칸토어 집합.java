import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) break;

            int n = (int) Math.pow(3, Integer.parseInt(s));

            String str = "-".repeat(n);
            answer.append(str);
            func(0, str.length());

            sb.append(answer.toString()).append("\n");
            answer.setLength(0);
        }

        System.out.println(sb);
    }

    private static void func(int start, int size) {
        if (size == 1) return;
        int newSize = size / 3;

        for (int i = start + newSize; i < start + newSize * 2; i++) {
            answer.setCharAt(i, ' ');
        }

        func(start, newSize);
        func(start + newSize * 2, newSize);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        int min = Integer.MAX_VALUE;
        int n = B.length() - A.length();
        int i = 0;

        if (A.length() == B.length()) {
            min = Math.min(min, compare(A, B));
        } else if (n == 1) {
            min = Math.min(min, compare(B.charAt(0) + A, B));
            min = Math.min(min, compare(A + B.charAt(B.length() - 1), B));
        } else {
            min = Math.min(min, compare(B.substring(0, n) + A, B));
            min = Math.min(min, compare(A + B.substring(A.length() + 1, B.length()), B));
        }

        // A 문자열이 중간에 위치한 경우
        while (n > 0) {
            String tempA = B.substring(0, i) + A;
            String temp = tempA + B.substring(tempA.length(), tempA.length() + n);
            min = Math.min(min, compare(temp, B));
            i++;
            n--;
        }

        System.out.println(min);
    }

    private static int compare(String A, String B) {
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(grade(Integer.parseInt(br.readLine())));
    }

    private static String grade(int n) {
        if (n >= 90) {
            return "A";
        } else if (n >= 80) {
            return "B";
        } else if (n >= 70) {
            return "C";
        } else if (n >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if (a == b && b == c) System.out.println("Equilateral");
        else if (a + b + c == 180) {
            if (a == b || a == c || b == c) System.out.println("Isosceles");
            else System.out.println("Scalene");
        } else System.out.println("Error");
    }


}


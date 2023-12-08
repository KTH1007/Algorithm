import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n >= 620 && n <= 780) System.out.println("Red");
        else if (n >= 590 && n < 620) System.out.println("Orange");
        else if (n >= 570 && n < 590) System.out.println("Yellow");
        else if (n >= 495 && n < 570) System.out.println("Green");
        else if (n >= 450 && n < 495) System.out.println("Blue");
        else if (n >= 425 && n < 450) System.out.println("Indigo");
        else if (n >= 380 && n < 425) System.out.println("Violet");

    }


}



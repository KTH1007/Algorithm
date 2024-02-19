import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.equals("fdsajkl;") || s.equals("jkl;fdsa")) System.out.println("in-out");
        else if (s.equals("asdf;lkj") || s.equals(";lkjasdf")) System.out.println("out-in");
        else if (s.equals("asdfjkl;")) System.out.println("stairs");
        else if (s.equals(";lkjfdsa")) System.out.println("reverse");
        else System.out.println("molu");
    }

}

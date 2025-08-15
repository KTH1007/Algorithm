import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String bitA = br.readLine();
        String bitB = br.readLine();

        StringBuilder andAB = new StringBuilder();
        StringBuilder orAB = new StringBuilder();
        StringBuilder xorAB = new StringBuilder();
        StringBuilder notA = new StringBuilder();
        StringBuilder notB = new StringBuilder();

        int bitALen = bitA.length();
        for (int i = 0; i < bitALen; i++) {
            boolean bitABool = bitA.charAt(i) == '1';
            boolean bitBBool = bitB.charAt(i) == '1';

            if (bitABool & bitBBool){
                andAB.append("1");
            }else {
                andAB.append("0");
            }

            if (bitABool | bitBBool){
                orAB.append("1");
            }else {
                orAB.append("0");
            }

            if (bitABool != bitBBool){
                xorAB.append("1");
            }else {
                xorAB.append("0");
            }

            if (!bitABool){
                notA.append("1");
            }else {
                notA.append("0");
            }

            if (!bitBBool){
                notB.append("1");
            }else {
                notB.append("0");
            }
        }

        System.out.println(andAB);
        System.out.println(orAB);
        System.out.println(xorAB);
        System.out.println(notA);
        System.out.println(notB);

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = s.split("-");
        int plus = 0;
        String[] temp = arr[0].split("\\+");
        for (int i = 0; i < temp.length; i++) {
            plus += Integer.parseInt(temp[i]);
        }
        int minus = 0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i].split("\\+");
            for (int j = 0; j < temp.length; j++) {
                minus += Integer.parseInt(temp[j]);
            }
        }
        System.out.println(plus - minus);
    }


}
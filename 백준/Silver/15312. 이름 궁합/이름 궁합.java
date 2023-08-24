import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[] arr = new int[s1.length() + s2.length()];
        for (int i = 0; i < arr.length - 1; i+=2) {
            arr[i] = count[s1.charAt(i / 2) - 'A'];
            arr[i + 1] = count[s2.charAt(i / 2) - 'A'];
        }
        int size = arr.length;
        while (size > 2) {
            for (int i = 0; i < size - 1; i++) {
                arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            size--;
        }
        System.out.println(arr[0] + "" + arr[1]);
    }


}
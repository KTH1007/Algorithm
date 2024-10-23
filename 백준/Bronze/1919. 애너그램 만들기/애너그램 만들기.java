import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int[] arr1 = stringToArray(A);
        int[] arr2 = stringToArray(B);

        System.out.println(compare(arr1, arr2));
    }

    private static int[] stringToArray(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        return arr;
    }

    private static int compare(int[] arr1, int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                if (arr1[i] > arr2[i]) {
                    count += arr1[i] - arr2[i];
                } else {
                    count += arr2[i] - arr1[i];
                }
            }
        }
        return count;
    }
}

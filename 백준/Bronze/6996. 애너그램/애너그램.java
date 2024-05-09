import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String s1 = st.nextToken();
            String s2 = st.nextToken();
            String[] arr1 = new String[s1.length()];
            String[] arr2 = new String[s2.length()];

            for (int i = 0; i < s1.length(); i++) {
                arr1[i] = Character.toString(s1.charAt(i));
            }
            Arrays.sort(arr1);

            for (int i = 0; i < s2.length(); i++) {
                arr2[i] = Character.toString(s2.charAt(i));
            }
            Arrays.sort(arr2);

            if (Arrays.toString(arr1).equals(Arrays.toString(arr2))) {
                sb.append(s1 + " & " + s2 + " are anagrams.").append("\n");
            } else {
                sb.append(s1 + " & " + s2 + " are NOT anagrams.").append("\n");
            }
        }

        System.out.println(sb);
    }

}

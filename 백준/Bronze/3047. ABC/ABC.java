import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Character, Integer> map = new HashMap<>();

        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        map.put('A', arr[0]);
        map.put('B', arr[1]);
        map.put('C', arr[2]);

        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        for (int i = 0; i < 3; i++) {
            char c = s.charAt(i);
            sb.append(map.get(c)).append(" ");
        }

        System.out.println(sb);

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[4];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') arr[0]++;
            else if (c == 'O') arr[1]++;
            else if (c == 'V') arr[2]++;
            else if (c == 'E') arr[3]++;
        }

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            int[] tempArr = new int[4];

            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                if (c == 'L') tempArr[0]++;
                else if (c == 'O') tempArr[1]++;
                else if (c == 'V') tempArr[2]++;
                else if (c == 'E') tempArr[3]++;
            }
            tempArr[0] += arr[0];
            tempArr[1] += arr[1];
            tempArr[2] += arr[2];
            tempArr[3] += arr[3];

            int L = tempArr[0];
            int O = tempArr[1];
            int V = tempArr[2];
            int E = tempArr[3];

            int a = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
            map.put(temp, a);
        }

        int max = -1;

        StringBuilder sb = new StringBuilder();

        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                List<String> list = new ArrayList<>();
                list.add(sb.toString());
                list.add(key);
                Collections.sort(list);
                sb.setLength(0);
                sb.append(list.get(0));


            } else if (map.get(key) > max) {
                max = map.get(key);
                sb.setLength(0);
                sb.append(key);
            }
        }

        System.out.println(sb);
    }
}

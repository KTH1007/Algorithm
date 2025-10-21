import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = mapping(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].equals(arr[j])) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static String mapping(String str) {
        int index = 97;
        Map<Character, Character> map = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, (char) index++);
            }

            answer.append(map.get(c));
        }

        return answer.toString();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], String.valueOf(i));
        }
        List<String> list = new ArrayList<>();

        numToString(m, n, arr, list);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        stringToNum(list, map, sb);
        System.out.println(sb);
    }

    private static void stringToNum(List<String> list, HashMap<String, String> map, StringBuilder sb) {
        for (int i = 0; i < list.size(); i++) {
            String[] numbers = list.get(i).split(" ");
            StringBuilder string = new StringBuilder();
            for (String number : numbers) {
                string.append(map.get(number));
            }
            sb.append(string.toString()).append(" ");

            if (i % 10 == 9) {
                sb.append("\n");
            }
        }
    }

    private static void numToString(int m, int n, String[] arr, List<String> list) {
        for (int i = m; i <= n; i++) {
            StringBuilder string = new StringBuilder();
            String temp = String.valueOf(i);
            for (int j = 0; j < temp.length(); j++) {
                string.append(arr[temp.charAt(j) - '0']).append(" ");
            }
            list.add(string.toString());
        }
    }

}

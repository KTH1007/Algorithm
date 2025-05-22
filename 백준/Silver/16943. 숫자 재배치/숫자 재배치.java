import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        arr = new String[a.length()];
        for (int i = 0; i < a.length(); i++) {
            arr[i] = a.charAt(i) + "";
        }

        dfs("", new ArrayList<>());

        list.sort((o1, o2) -> o2 - o1);

        int answer = -1;
        for (Integer i : list) {
            if (i < b) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }

    private static void dfs(String num, List<Integer> selected) {
        if (num.length() == arr.length) {
            if (num.charAt(0) != '0') {
                list.add(Integer.parseInt(num));
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!selected.contains(i)) {
                selected.add(i);
                dfs(num + arr[i], selected);
                selected.remove(selected.size() - 1);
            }
        }
    }
}

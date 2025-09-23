import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, int[]> conKey = new HashMap<>();
    static Map<String, int[]> vowelKey = new HashMap<>();
    static int[] leftHand;
    static int[] rightHand;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapInit();
        StringTokenizer st = new StringTokenizer(br.readLine());

        leftHand = conKey.get(st.nextToken());
        rightHand = vowelKey.get(st.nextToken());

        System.out.println(calTime(br.readLine()));
    }

    private static int calTime(String s) {
        int time = 0;
        int[] start = new int[2];
        int[] destination = new int[2];
        for (int i = 0; i < s.length(); i++) {
            String str = s.charAt(i) + "";

            if (conKey.containsKey(str)) {
                start = leftHand;
                destination = conKey.get(str);
                leftHand = destination;
            } else {
                start = rightHand;
                destination = vowelKey.get(str);
                rightHand = destination;
            }

            time += Math.abs(start[0] - destination[0]) + Math.abs(start[1] - destination[1]);
            time++;
        }

        return time;
    }

    private static void mapInit() {
        conKey.put("q", new int[]{0, 0});
        conKey.put("w", new int[]{0, 1});
        conKey.put("e", new int[]{0, 2});
        conKey.put("r", new int[]{0, 3});
        conKey.put("t", new int[]{0, 4});
        vowelKey.put("y", new int[]{0, 5});
        vowelKey.put("u", new int[]{0, 6});
        vowelKey.put("i", new int[]{0, 7});
        vowelKey.put("o", new int[]{0, 8});
        vowelKey.put("p", new int[]{0, 9});

        conKey.put("a", new int[]{1, 0});
        conKey.put("s", new int[]{1, 1});
        conKey.put("d", new int[]{1, 2});
        conKey.put("f", new int[]{1, 3});
        conKey.put("g", new int[]{1, 4});
        vowelKey.put("h", new int[]{1, 5});
        vowelKey.put("j", new int[]{1, 6});
        vowelKey.put("k", new int[]{1, 7});
        vowelKey.put("l", new int[]{1, 8});

        conKey.put("z", new int[]{2, 0});
        conKey.put("x", new int[]{2, 1});
        conKey.put("c", new int[]{2, 2});
        conKey.put("v", new int[]{2, 3});
        vowelKey.put("b", new int[]{2, 4});
        vowelKey.put("n", new int[]{2, 5});
        vowelKey.put("m", new int[]{2, 6});
    }
}

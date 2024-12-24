import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        int kingX = s.charAt(0) - 'A' + 1;
        int kingY = s.charAt(1) - '0';

        s = st.nextToken();
        int rockX = s.charAt(0) - 'A' + 1;
        int rockY = s.charAt(1) - '0';

        int t = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("L", 1);
        map.put("B", 2);
        map.put("T", 3);
        map.put("RT", 4);
        map.put("LT", 5);
        map.put("RB", 6);
        map.put("LB", 7);
        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

        while (t-- > 0) {
            String move = br.readLine();
            int k = map.get(move);

            int kingNX = kingX + dx[k];
            int kingNY = kingY + dy[k];

            if (kingNX > 0 && kingNX < 9 && kingNY > 0 && kingNY < 9) {
                if (kingNX == rockX && kingNY == rockY) {
                    int rockNX = rockX + dx[k];
                    int rockNY = rockY + dy[k];
                    if (rockNX > 0 && rockNX < 9 && rockNY > 0 && rockNY < 9) {
                        kingX = kingNX;
                        kingY = kingNY;

                        rockX = rockNX;
                        rockY = rockNY;
                    }
                } else {
                    kingX = kingNX;
                    kingY = kingNY;
                }
            }
        }

        String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H"};

        System.out.println(alpha[kingX - 1] + "" + kingY);
        System.out.println(alpha[rockX - 1] + "" + rockY);
    }

}

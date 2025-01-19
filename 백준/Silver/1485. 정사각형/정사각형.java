import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            List<Coordinate> points = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                points.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            if (isSquare(points)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isSquare(List<Coordinate> points) {
        // 점들의 모든 거리 계산
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                distances.add(points.get(i).distanceSquared(points.get(j)));
            }
        }

        distances.sort(null);

        // 정사각형 조건 확인
        // - 짧은 거리(변의 길이) 4개와 긴 거리(대각선 길이) 2개
        // - 대각선 길이는 변의 길이의 두 배
        return distances.get(0).equals(distances.get(1)) &&
                distances.get(1).equals(distances.get(2)) &&
                distances.get(2).equals(distances.get(3)) && // 변의 길이 4개
                distances.get(4).equals(distances.get(5)) && // 대각선 길이 2개
                distances.get(4) == 2 * distances.get(0);
    }

    static class Coordinate{
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distanceSquared(Coordinate o) {
            return (this.x - o.x) * (this.x - o.x) + (this.y - o.y) * (this.y - o.y);
        }
    }
}

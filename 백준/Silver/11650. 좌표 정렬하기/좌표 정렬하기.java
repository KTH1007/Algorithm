import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        List<Coordinate> list = new ArrayList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            list.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        list.sort(null);

        StringBuilder sb = new StringBuilder();
        for (Coordinate coordinate : list) {
            sb.append(coordinate.getX()).append(" ").append(coordinate.getY()).append("\n");
        }

        System.out.println(sb);
    }

    private static class Coordinate implements Comparable<Coordinate>{
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}

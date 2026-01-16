import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Number {
    private int num;
    private String str;

    public Number(int num, String str) {
        this.num = num;
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public String getStr() {
        return str;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String[] tokens;

        while (t-- > 0) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            bfs(a, b);
        }

        System.out.println(sb);
    }

    private static void bfs(int a, int b) {
        boolean[] visited = new boolean[10001];
        visited[a] = true;
        Queue<Number> queue = new ArrayDeque<>();
        queue.add(new Number(a, ""));

        while (!queue.isEmpty()) {
            Number current = queue.poll();
            int num = current.getNum();
            String str = current.getStr();

            if (num == b) {
                sb.append(str).append("\n");
                return;
            }

            if (!visited[functionD(num)]) {
                queue.add(new Number(functionD(num), str + "D"));
                visited[functionD(num)] = true;
            }

            if (!visited[functionS(num)]) {
                queue.add(new Number(functionS(num), str + "S"));
                visited[functionS(num)] = true;
            }

            if (!visited[functionL(num)]) {
                queue.add(new Number(functionL(num), str + "L"));
                visited[functionL(num)] = true;
            }

            if (!visited[functionR(num)]) {
                queue.add(new Number(functionR(num), str + "R"));
                visited[functionR(num)] = true;
            }
        }
    }

    private static int functionD(int num) {
        int returnNum = num * 2;

        if (returnNum > 9999) {
            return returnNum % 10000;
        }
        return returnNum;
    }

    private static int functionS(int num) {
        int returnNum = num - 1;

        if (returnNum < 0) {
            return 9999;
        }
        return returnNum;
    }

    private static int functionL(int num) {
        int first = num / 1000;
        int second = num % 1000 / 100;
        int third = num % 100 / 10;
        int fourth = num % 10;

        int returnNum = second * 1000 + third * 100 + fourth * 10 + first;
        return returnNum;
    }

    private static int functionR(int num) {
        int first = num / 1000;
        int second = num % 1000 / 100;
        int third = num % 100 / 10;
        int fourth = num % 10;

        int returnNum = fourth * 1000 + first * 100 + second * 10 + third;
        return returnNum;
    }
}

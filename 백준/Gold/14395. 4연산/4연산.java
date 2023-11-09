import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final long limit = 1000000000L;
    static int s, t;
    static String result = "-1";
    static HashSet<Long> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        if (s == t) {
            System.out.println(0);
            return;
        }
        bfs();
        System.out.println(result);

    }

    static void bfs() {
        Queue<Num> queue = new LinkedList<>();
        queue.add(new Num(s, ""));
        set.add((long) s);
        while (!queue.isEmpty()) {
            Num current = queue.poll();
            long currentNum = current.num;
            String currentHistory = current.history;
            if (currentNum == t) {
                result = currentHistory;
                return;
            }
            if (currentNum * currentNum <= limit && !set.contains(currentNum * currentNum)) {
                queue.add(new Num(currentNum * currentNum, currentHistory + "*"));
                set.add(currentNum * currentNum);
            }
            if (currentNum + currentNum <= limit && !set.contains(currentNum + currentNum)) {
                queue.add(new Num(currentNum + currentNum, currentHistory + "+"));
                set.add(currentNum + currentNum);
            }
            if (!set.contains(0L)) {
                queue.add(new Num(0, currentHistory + "-"));
                set.add(0L);
            }
            if (currentNum != 0 && !set.contains(1L)) {
                queue.add(new Num(1, currentHistory + "/"));
                set.add(1L);
            }
        }
    }

    static class Num {
        long num;
        String history;

        Num(long num, String history) {
            this.num = num;
            this.history = history;
        }
    }


}

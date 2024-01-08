import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int s, t;
    static boolean flag = false;
    static HashSet<Long> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        if (s == t) {
            System.out.println(0);
        } else {
            bfs();
            if (!flag) System.out.println(-1);
        }

    }

    static void bfs() {
        Queue<OP> queue = new LinkedList<>();
        queue.add(new OP("", s));
        set.add((long) s);
        while (!queue.isEmpty()) {
            OP op = queue.poll();
            if (op.num == t) {
                System.out.println(op.s);
                flag = true;
                return;
            }
            if (op.num * op.num < 1000000001 && !set.contains(op.num * op.num)) {
                set.add(op.num * op.num);
                queue.add(new OP(op.s + "*", op.num * op.num));
            }
            if (op.num + op.num < 1000000001 && !set.contains(op.num + op.num)) {
                set.add(op.num + op.num);
                queue.add(new OP(op.s + "+", op.num + op.num));
            }
            if (!set.contains(0L)) {
                set.add(0L);
                queue.add(new OP(op.s + "-", 0));
            }
            if (op.num != 0 && !set.contains(1L)) {
                set.add(1L);
                queue.add(new OP(op.s + "/", 1));
            }

        }
    }

    static class OP {
        String s;
        long num;

        OP(String s, long num) {
            this.s = s;
            this.num = num;
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static long s, t;
    static HashSet<Long> set = new HashSet<>();
    static String[] order = {"*", "+", "-", "/"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        BFS();
    }

    static void BFS() {
        if (s == t) {
            System.out.println(0);
            return;
        }
        Queue<Num> queue = new LinkedList<>();
        queue.add(new Num(s, ""));
        set.add(s);
        while (!queue.isEmpty()) {
            Num current = queue.poll();
            long currentNum = current.num;
            String currentHistory = current.history;
            long next = currentNum;
            if (currentNum == t) {
                System.out.println(currentHistory);
                return;
            }
            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        next = currentNum * currentNum;
                        break;
                    case 1:
                        next = currentNum + currentNum;
                        break;
                    case 2:
                        next = 0;
                        break;
                    case 3:
                        if (currentNum != 0) next = 1;
                        break;
                }

                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(new Num(next, currentHistory + order[i]));
                }
            }
        }
        System.out.println(-1);
    }

    static class Num {
        long num;
        String history = "";

        Num(long num, String history) {
            this.num = num;
            this.history = history;
        }
    }

}
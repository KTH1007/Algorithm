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

        int sum = 0;
        int num = 0;
        int a = 0;
        int t = 0;

        List<Assignment> list = new ArrayList<>();

        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());

            if (num == 1) {
                if (t == 0) {
                    a = Integer.parseInt(st.nextToken());
                    t = Integer.parseInt(st.nextToken()) - 1;
                } else {
                    int newA = Integer.parseInt(st.nextToken());
                    int newT = Integer.parseInt(st.nextToken()) - 1;
                    list.add(new Assignment(a, t));
                    a = newA;
                    t = newT;
                    if (t == 0) {
                        sum += a;
                        if (!list.isEmpty()) {
                            a = list.get(list.size() - 1).getScore();
                            t = list.get(list.size() - 1).getTime();
                            list.remove(list.size() - 1);
                        } else {
                            a = 0;
                        }
                    }
                }
            } else {
                t--;
                if (t == 0) {
                    sum += a;
                    if (!list.isEmpty()) {
                        a = list.get(list.size() - 1).getScore();
                        t = list.get(list.size() - 1).getTime();
                        list.remove(list.size() - 1);
                    } else {
                        a = 0;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    static class Assignment {
        private int score = 0;
        private int time = 0;

        public Assignment(int score, int time) {
            this.score = score;
            this.time = time;
        }

        public int getScore() {
            return score;
        }

        public int getTime() {
            return time;
        }
    }

}

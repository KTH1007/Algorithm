import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<Integer>[] edges;
    static boolean[] people;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        edges = new ArrayList[n + 1];
        people = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        tokens = br.readLine().split(" ");
        int count = Integer.parseInt(tokens[0]);

        for (int i = 0; i < count; i++) {
            people[Integer.parseInt(tokens[i + 1])] = true;
        }

        int total = 0;

        List<List<Integer>> parties = new ArrayList<>();

        while (m-- > 0) {
            tokens = br.readLine().split(" ");
            count = Integer.parseInt(tokens[0]);

            List<Integer> party = new ArrayList<>();
            for (int i = 1; i <= count; i++) {
                party.add(Integer.parseInt(tokens[i]));
            }

            parties.add(party);

            for (int i = 0; i < party.size(); i++) {
                for (int j = i + 1; j < party.size(); j++) {
                    edges[party.get(i)].add(party.get(j));
                    edges[party.get(j)].add(party.get(i));
                }
            }
        }

        bfs();

        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (Integer person : party) {
                if (people[person]) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) {
                total++;
            }
        }

        System.out.println(total);
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (people[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < edges[current].size(); i++) {
                int next = edges[current].get(i);

                if (!visited[next]) {
                    people[next] = true;
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}

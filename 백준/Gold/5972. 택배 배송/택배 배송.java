import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Node>> list = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }
        dijkstra();
        System.out.println(distance[n]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        distance[1] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            for (int i = 0; i < list.get(current.v).size(); i++) {
                Node next = list.get(current.v).get(i);
                if (distance[next.v] > distance[current.v] + next.cost) {
                    distance[next.v] = distance[current.v] + next.cost;
                    pq.add(new Node(next.v, distance[next.v]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }


}


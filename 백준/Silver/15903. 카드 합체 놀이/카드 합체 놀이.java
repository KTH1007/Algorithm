import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<BigInteger> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(new BigInteger(st.nextToken()));
        }

        while (m-- > 0) {
            BigInteger x = pq.poll();
            BigInteger y = pq.poll();

            pq.offer(x.add(y));
            pq.offer(x.add(y));
        }

        BigInteger sum = BigInteger.ZERO;
        while (!pq.isEmpty()) {
            sum = sum.add(pq.poll());
        }

        System.out.println(sum);
    }

}

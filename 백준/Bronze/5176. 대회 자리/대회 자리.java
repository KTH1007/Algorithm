import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean[] seats = new boolean[M + 1];

            int cannotSitCount = 0;

            for (int i = 0; i < P; i++) {
                int preferredSeat = Integer.parseInt(br.readLine());

                if (!seats[preferredSeat]) {
                    seats[preferredSeat] = true;
                } else {
                    cannotSitCount++;
                }
            }

            bw.write(cannotSitCount + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
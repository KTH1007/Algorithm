import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long maxHelmet = 0;
        for(int i = 0; i < N; i++) {
            long helmet = Long.parseLong(st.nextToken());
            if(helmet > maxHelmet) {
                maxHelmet = helmet;
            }
        }

        st = new StringTokenizer(br.readLine());
        long maxVest = 0;
        for(int i = 0; i < M; i++) {
            long vest = Long.parseLong(st.nextToken());
            if(vest > maxVest) {
                maxVest = vest;
            }
        }

        bw.write(String.valueOf(maxHelmet + maxVest));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] score = new int[5];
            for (int j = 0; j < score.length; j++) {
                score[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(score);

            if (score[3] - score[1] >= 4) {
                System.out.println("KIN");
            } else {
                int sum = score[1] + score[2] + score[3];
                System.out.println(sum);
            }
        }
    }
}

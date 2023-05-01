import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int length = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] dna = new int[4];
        for(int i=0; i<4; i++){
            dna[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int[] check = new int[4];
        for (int i = 0; i < p; i++) {
            char c = s.charAt(i);
            if (c == 'A')
                check[0]++;
            else if (c == 'C')
                check[1]++;
            else if (c == 'G')
                check[2]++;
            else
                check[3]++;
        }
        if (check[0] >= dna[0] && check[1] >= dna[1] && check[2] >= dna[2] && check[3] >= dna[3]) {
            count++;
        }
        for (int i = p; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'A')
                check[0]++;
            else if (c == 'C')
                check[1]++;
            else if (c == 'G')
                check[2]++;
            else
                check[3]++;
            c = s.charAt(i - p);
            if (c == 'A')
                check[0]--;
            else if (c == 'C')
                check[1]--;
            else if (c == 'G')
                check[2]--;
            else
                check[3]--;
            if (check[0] >= dna[0] && check[1] >= dna[1] && check[2] >= dna[2] && check[3] >= dna[3]) {
                count++;
            }
        }
        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] s = new String[n];
        for(int i=0; i<n; i++){
            s[i] = br.readLine();
        }
        for(int i=0; i<m; i++){
            int[] alpha = new int[4];
            for(int j=0; j<n; j++){
                if(s[j].charAt(i) == 'A')
                    alpha[0]++;
                else if(s[j].charAt(i) == 'C')
                    alpha[1]++;
                else if(s[j].charAt(i) == 'G')
                    alpha[2]++;
                else alpha[3]++;
            }
            int idx = 0;
            int max = 0;
            for(int j=0; j<4; j++){
                if(alpha[j] > max || (alpha[j] == max && j < idx)){
                    max = alpha[j];
                    idx = j;
                }
            }
            if(idx == 0)
                sb.append("A");
            else if(idx == 1)
                sb.append("C");
            else if(idx == 2)
                sb.append("G");
            else sb.append("T");
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(sb.charAt(j) != s[i].charAt(j))
                    count++;
            }
        }

        System.out.println(sb);
        System.out.println(count);

    }
}
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
        for(int i=0; i<n; i++){
            int t = Integer.parseInt(br.readLine());
            char[] s = new char[t];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<t; j++){
                s[j] = st.nextToken().charAt(0);
            }
            String answer = "";
            answer += Character.toString(s[0]);
            for(int j=1; j<s.length; j++){
                if(s[j] <= answer.charAt(0)){
                    answer = s[j] + answer;
                }
                else answer = answer + s[j];
            }
            System.out.println(answer);
        }
    }
}

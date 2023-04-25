import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int[] alpha = new int[26];
        for(int i=0; i<s.length(); i++){
            alpha[s.charAt(i) - 'A']++;
        }
        int center = 0;
        char cen = ' ';
        //알파벳 개수가 홀수인 알파벳이 2개 이상이면 팰린드롬 못 만듦
        for(int i=0; i<alpha.length; i++){
            if(alpha[i] % 2 != 0){
                center++;
                cen = (char)(i + 65);
            }
        }
        if(center > 1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        for(int i=0; i<alpha.length; i++){
            for(int j=0; j<alpha[i]/2; j++){
                sb.append((char)(i+65));
            }
        }
        String s2 = sb.toString();
        if(center == 1){
            sb.append(cen);
        }
        for(int i=s2.length()-1; i>=0; i--){
            sb.append(s2.charAt(i));
        }
        System.out.println(sb);

    }
}

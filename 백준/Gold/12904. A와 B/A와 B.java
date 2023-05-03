import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String s1 = br.readLine();
        String s2 = br.readLine();
        int i=0;
        while (s1.length() < s2.length()) {
            if(s2.charAt(s2.length()-1) == 'A'){
                s2 = s2.substring(0,s2.length()-1);
            }
            else if(s2.charAt(s2.length()-1) == 'B'){
                s2 = s2.substring(0, s2.length()-1);
                StringBuilder sb = new StringBuilder();
                sb.append(s2);
                sb.reverse();
                s2 = sb.toString();
            }

        }
        if(s1.equals(s2))
            answer = 1;
        else answer = 0;
        //System.out.println(s1);
        System.out.println(answer);
    }
}
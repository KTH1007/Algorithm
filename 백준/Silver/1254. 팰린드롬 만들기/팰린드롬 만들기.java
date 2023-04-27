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
        int count = s.length();
        int i= 1;
        while (true){
            // 9  0~3  4 ~ 8
            //10  0~4  5~9
            if(s.length() % 2 == 0){
                String s2 = s.substring(s.length()/2);
                String reversedS = new StringBuilder(s2).reverse().toString();
                if(s.substring(0,s.length()/2).equals(reversedS)){
                    System.out.println(count + i -1);
                    return;
                }
            }
            else{
                String s2 = s.substring(s.length()/2+1);
                String reversedS = new StringBuilder(s2).reverse().toString();
                if(s.substring(0,s.length()/2).equals(reversedS)){
                    System.out.println(count + i - 1);
                    return;
                }
            }
            s = s.substring(1);
            i++;
        }
    }
}
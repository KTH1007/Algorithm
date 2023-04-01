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
        // n==1 cy n==2 sk n==3 cy n==4 sk  n==5 cy
        //n이 홀수일 때는 CY승
        if(n%2 != 0)
            System.out.println("CY");
        else System.out.println("SK");
    }
}

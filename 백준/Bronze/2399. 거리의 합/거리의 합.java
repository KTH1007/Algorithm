import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        int [] x = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            x[i]=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                ans+=Math.abs(x[i]-x[j]);
        System.out.println(ans*2);
    }
}

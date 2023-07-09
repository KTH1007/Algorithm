import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = {1,1,2,2,2,8};
        int[] arr2 = new int[arr.length];
        for(int i=0; i<arr2.length; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<arr2.length; i++){
            sb.append(arr[i]-arr2[i]).append(" ");
        }
        System.out.println(sb);
    }

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[][] arr = new int[15][15];
        for(int i=1; i<=14; i++){
            arr[0][i] = i;
        }
        for(int i=1; i<=14; i++){
            for(int j=1; j<=14; j++){
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
        while (t-- > 0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[k][n]);
        }
    }
}


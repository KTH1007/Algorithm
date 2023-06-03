import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                if(s.charAt(j) == 'N')
                    arr[i][j] = Integer.MAX_VALUE / 2;
                else arr[i][j] = 1;
                if(i == j) arr[i][j] = 0;
            }
        }
        //플로이드 워셜 알고리즘
        for(int k=0; k<n; k++){  //경유지
            for(int i=0; i<n; i++){  //출발지
                for(int j=0; j<n; j++){  //도착지
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+ arr[k][j]);
                }
            }
        }
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(arr[i][j]<=2) count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }


}

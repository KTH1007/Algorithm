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
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        //서로 다른 색상들로 합을 구함
        for(int i=1; i<n; i++){
            arr[i][0] += Math.min(arr[i-1][1],arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0],arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0],arr[i-1][1]);
        }
        int answer = Math.min(arr[n-1][0], Math.min(arr[n-1][1],arr[n-1][2]));
        System.out.println(answer);
    }
}

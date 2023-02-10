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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int i=0;
        int j=n-1;
        int answer = Integer.MAX_VALUE;
        int t1 = 0;
        int t2 = 0;
        while (i<j){
            if(arr[i] + arr[j] == 0){
                t1 = arr[i];
                t2 = arr[j];
                break;
            }
            if(Math.abs(arr[i] + arr[j]) < answer){
                t1 = arr[i];
                t2 = arr[j];
                answer = Math.abs(arr[i] + arr[j]);
            }
            if(arr[i]+arr[j] > 0)
                j--;
            else
                i++;
        }
        System.out.println(t1 + " " + t2);
    }
}

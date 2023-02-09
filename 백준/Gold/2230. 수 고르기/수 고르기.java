import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int i = 0;
        int j = 0;
        int answer = Integer.MAX_VALUE;
        while(i<n){
            if((arr[i] - arr[j]) < m){
                i++;
                continue;
            }
            if((arr[i] - arr[j]) == m){
                answer = m;
                break;
            }
            answer = Math.min(answer,arr[i]-arr[j]);
            j++;
        }
        System.out.println(answer);
    }
}

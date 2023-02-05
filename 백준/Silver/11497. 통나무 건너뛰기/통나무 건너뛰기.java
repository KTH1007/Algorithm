import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int max = 0;
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int[] answer = new int[n];
            int left = 0;
            int right = n-1;
            for(int j=0; j<n; j++){
                if(j % 2 == 0){
                    answer[left] = arr[j];
                    left++;
                }
                else {
                    answer[right] = arr[j];
                    right--;
                }
            }
            for(int j=0; j<n-1; j++){
                max = Math.max(max, Math.abs(answer[j+1] - answer[j]));
            }
            max = Math.max(max, Math.abs(answer[0] - answer[n-1]));
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
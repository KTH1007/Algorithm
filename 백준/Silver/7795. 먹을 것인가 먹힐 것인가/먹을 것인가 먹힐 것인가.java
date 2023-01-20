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
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[a];
            int[] arr2 = new int[b];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<a; j++){
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<b; j++){
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int count = 0;
            for(int j=0; j<a; j++){
                for(int k=0; k<b; k++){
                    if(arr1[j]<=arr2[k])
                        break;
                    else count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}

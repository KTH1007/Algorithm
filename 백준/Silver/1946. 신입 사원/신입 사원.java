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
            int[][] arr = new int[n][2];
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[j][0] = a;
                arr[j][1] = b;
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] < o2[0])
                        return -1;
                    else
                        return 1;
                }
            });
            int max = arr[0][1];
            int count = 1;
            for(int j=0; j<n; j++){
                if(max > arr[j][1]){
                    count++;
                    max = arr[j][1];
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}

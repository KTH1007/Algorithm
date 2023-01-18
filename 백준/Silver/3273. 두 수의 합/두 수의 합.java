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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = n-1;
        while (start < end){
            sum = arr[start] + arr[end];
            if(sum == x)
                count++;
            if(sum <= x)
                start++;
            else
                end--;
        }
        System.out.println(count);
    }
}
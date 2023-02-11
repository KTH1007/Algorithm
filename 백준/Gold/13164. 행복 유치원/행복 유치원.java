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
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] gab = new int[n-1];
        for(int i=0; i<n-1; i++){
            gab[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(gab);
        int answer = 0;
        for(int i=0; i<n-k; i++){
            answer += gab[i];
        }
        System.out.println(answer);
    }
}
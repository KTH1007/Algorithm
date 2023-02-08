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
        int k = Integer.parseInt(br.readLine());
        if(k >= n) {
            System.out.println(0);
            return;
        }
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Integer[] dif = new Integer[n-1];
        for(int i=0; i<n-1; i++){
            dif[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(dif, Collections.reverseOrder());
        int sum = 0;
        //가장 높은 값은 간격이 제일 큰 곳으로 즉 하나의 구역에 포함시키지 않은 곳이다.
        for(int i= k-1; i<n-1; i++){
            sum += dif[i];
        }
        System.out.println(sum);
    }

}

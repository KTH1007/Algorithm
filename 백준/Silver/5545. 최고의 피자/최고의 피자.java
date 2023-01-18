import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int price = a;
        int cal = c;
        int ans = c / a;
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0; i<n; i++){
            price += b;
            cal += arr[i];
            int tmpAns = cal/price;
            if(ans > tmpAns)
                break;
            else ans = tmpAns;
        }
        System.out.println(ans);
    }
}

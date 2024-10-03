import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = st = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = i + 1;

        int M = Integer.parseInt(st.nextToken());

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            int k = Integer.parseInt(st.nextToken())-1;

            int[] tmp = new int[j-i+1];
            int tmpI = i;
            for(int l = 0; l < j-i+1; l++){
                if(k+l <= j)
                    tmp[l] = arr[k+l];
                else {
                    tmp[l] = arr[tmpI];
                    tmpI++;
                }
            }

            for(int l = i; l <= j; l++)
                arr[l] = tmp[l-i];
        }

        for(int num : arr)
            str.append(num).append(" ");

        System.out.print(str);
        br.close();
    }
}

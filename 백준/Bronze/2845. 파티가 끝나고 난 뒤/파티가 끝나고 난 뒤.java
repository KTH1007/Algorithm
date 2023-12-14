import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int mul = l * p;

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken()) - mul;

        for (int i = 0; i < 5; i++) System.out.print(arr[i] + " ");


    }


}



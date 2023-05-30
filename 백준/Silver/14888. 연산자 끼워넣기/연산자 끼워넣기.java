import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;
    static int[] op = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }
    static void DFS(int depth, int num){
        if(depth == n){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for(int i=0; i<4; i++){
            if(op[i] > 0){
                op[i]--;
                switch (i){
                    case 0:
                        DFS(depth+1, num + arr[depth]);
                        break;
                    case 1:
                        DFS(depth+1, num - arr[depth]);
                        break;
                    case 2:
                        DFS(depth+1, num * arr[depth]);
                        break;
                    case 3:
                        DFS(depth+1, num / arr[depth]);
                        break;
                }
                op[i]++;
            }
        }
    }

}

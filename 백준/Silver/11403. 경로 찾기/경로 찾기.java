import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // i에서 k까지 가고 k에서 j까지 갈 수 있는가?
        // 거쳐가는 노드
        for(int k=0; k<n; k++){
            // 출발 노드
            for(int i=0; i<n; i++){
                // 도착 노드
                for(int j=0; j<n; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1)
                        arr[i][j] = 1;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
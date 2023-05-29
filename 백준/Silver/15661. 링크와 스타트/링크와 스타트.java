import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[][] arr;
    static int n;
    static int answer = Integer.MAX_VALUE;

    static int t = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(t=1; t<n; t++){
            DFS(0,0);
        }
        System.out.println(answer);
    }
    static void DFS(int depth, int idx){
        if(depth == t){
            int start = 0;
            int link = 0;
            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    if(visited[i] && visited[j])
                        start += arr[i][j] + arr[j][i];
                    if(!visited[i] && !visited[j])
                        link += arr[i][j] + arr[j][i];
                }
            }
            answer = Math.min(answer, Math.abs(start - link));
        }
        for(int i=idx; i<n; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            DFS(depth+1, i+1);
            visited[i] = false;
        }
    }


}

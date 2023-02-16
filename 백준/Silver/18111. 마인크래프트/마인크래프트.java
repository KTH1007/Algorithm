import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int time = Integer.MAX_VALUE;
        int h = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }
        //최소층부터 최대층까지
        for(int i=min; i<=max; i++){
            int seconds = 0;
            int blocks = b;
            //i층으로 땅을 다지려고 할 때 층 높이와 시간을 저장
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(arr[j][k] > i){ //블록 제거
                        seconds += (arr[j][k] - i) * 2;
                        blocks += (arr[j][k] - i);
                    }
                    else if(arr[j][k] <i){  //블록 쌓기
                        seconds += (i - arr[j][k]);
                        blocks -= i - arr[j][k];
                    }
                }
            }
            if(blocks >= 0 && time >= seconds){
                time = seconds;
                h = i;
            }
        }
        System.out.println(time + " " + h);

    }
}


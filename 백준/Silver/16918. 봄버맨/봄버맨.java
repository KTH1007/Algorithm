import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,r,c;
    static char[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] bombTime;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        bombTime = new int[r][c];

        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                arr[i][j] = s.charAt(j);
                if(s.charAt(j) == 'O')
                    bombTime[i][j] = 3; //폭탄이 터질 시간
            }
        }
        int time = 0;
        while (time++ < n){
            if(time % 2 == 0){  //짝수 초에는 폭탄 설치
                for(int i=0; i<r; i++){
                    for(int j=0; j<c; j++){
                        if(arr[i][j] == '.'){
                            arr[i][j] = 'O';
                            bombTime[i][j] = time+3;
                        }
                    }
                }
            }
            else{
                for(int i=0; i<r; i++){
                    for(int j=0; j<c; j++){
                        if(bombTime[i][j] == time){
                            arr[i][j] = '.';
                            bombTime[i][j] = 0;
                            for(int k=0; k<4; k++){
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if(nx >= 0 && nx < r && ny >= 0 && ny<c){
                                    if(arr[nx][ny] == 'O' && bombTime[nx][ny] != time){
                                        arr[nx][ny] = '.';
                                        bombTime[nx][ny] = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

}
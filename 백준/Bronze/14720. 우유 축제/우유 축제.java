import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int milk = 0;
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //각 가게 방문!
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            if(milk == n){	//지금 먹을 우유와 같으면 먹기!
                //다음 먹을 우유로 변경!
                milk = milk + 1 == 3 ? 0 : milk + 1;
                answer++;	//우유 먹은 횟수 증가
            }
        }
        bw.write(answer +"");	//우유 먹은 횟수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();

    }
}
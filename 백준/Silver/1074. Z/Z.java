import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2,n);
        find(size, r, c);
        System.out.println(count);

    }
    static void find(int size, int r, int c){
        if(size == 1)
            return;

        if(r < size/2 && c < size/2){
            find(size/2, r, c);
        }
        //1사분면은 size/2 * size/2 의 위치를 처음 방문함
        else if(r < size/2 && c >= size/2){
            count += (size/2) * (size/2);
            find(size/2, r, c-size/2);
        }
        //3사분면은 size/2 * size*/2 * 2 위치를 처음으로 방문
        else if(r >= size/2 && c < size/2){
            count += (size/2) * (size/2) * 2;
            find(size/2, r-size/2, c);
        }
        //4사분면은 size/2 * size*/2 * 3 위치를 처음으로 방문
        else{
            count += (size/2) * (size/2) * 3;
            find(size, r-size/2, c-size/2);
        }
    }
}
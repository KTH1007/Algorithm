import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Long> list = new ArrayList<>();
    static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        //최대 10자리  9876543210 총 1024가지 방법 아무것도 선택하지 않으면 1023
        if(n<10){
            System.out.println(n);
            return;
        }
        else if(n > 1022){
            System.out.println(-1);
            return;
        }
        for(int i=0; i<10; i++){
            DFS(i, 1);
        }
        Collections.sort(list);
        System.out.println(list.get(n));

    }
    static void DFS(long num, int depth){
        if(depth > 10)
            return;
        list.add(num);
        for(int i=0; i< num%10; i++){
            DFS((num*10)+i, depth+1);
        }
    }

}

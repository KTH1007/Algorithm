import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Integer> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        DFS(list, 0);
        System.out.println(max);

    }
    static void DFS(List<Integer> list, int sum){
        if(list.size() == 2){
            max = Math.max(max, sum);
            return;
        }
        for(int i=1; i<list.size()-1; i++){
            int temp = list.get(i);
            int num = list.get(i-1)*list.get(i+1);
            list.remove(i);
            DFS(list, sum + num);
            list.add(i, temp);
        }
    }

}

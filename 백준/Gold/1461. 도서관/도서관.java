import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(Math.abs(num) > max){
                max = Math.abs(num);
            }
            if(num> 0)
                plus.add(num);
            else minus.add(Math.abs(num));
        }
        int count = 0;
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());
        for(int i=0; i<plus.size(); i++){
            if(plus.get(i) == max && i%m == 0){
                count += plus.get(i);
            }
            else if(i % m == 0)
                count += (plus.get(i) * 2);
        }

        for(int i=0; i<minus.size(); i++){
            if(minus.get(i) == max && i%m == 0){
                count += minus.get(i);
            }
            else if(i % m == 0){
                count += (minus.get(i) * 2);
            }
        }
        System.out.println(count);
    }

}
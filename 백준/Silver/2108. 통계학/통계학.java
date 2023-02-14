import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        double avg = (double) sum / (double) n;
        int answer = (int) Math.round(avg);
        sb.append((int)answer).append("\n");
        Arrays.sort(arr);
        sb.append(arr[n/2]).append("\n");
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else map.put(arr[i],1);
        }
        int num = 0;
        for(int key : map.values()){
            num = Math.max(num, key);
        }
        for(int key : map.keySet()){
            if(map.get(key) == num){
                list.add(key);
            }
        }
        Collections.sort(list);
        if(list.size() >= 2)
            sb.append(list.get(1)).append("\n");
        else sb.append(list.get(0)).append("\n");
        sb.append(arr[n-1]-arr[0]);
        System.out.println(sb);

    }
}

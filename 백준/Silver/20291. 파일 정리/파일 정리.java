import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            arr[i] = s.substring(s.indexOf('.')+1);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String key = arr[i];
            if(map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }
            else {
                map.put(key, 1);
            }
        }
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(i>0 && arr[i].equals(arr[i-1]))
                continue;
            sb.append(arr[i]).append(" ").append(map.get(arr[i])).append("\n");
        }
        System.out.println(sb);
    }
}
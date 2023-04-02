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
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            int a = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            for(int j=0; j<a; j++){
                list.add(br.readLine());
            }
            map.put(s,list);
        }
        for(int i=0; i<m; i++){
            String s = br.readLine();
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                List<String> value1 = map.get(s);
                Collections.sort(value1);
                for(String value : value1){
                    System.out.println(value);
                }
            }
            else if(a == 1){
                for(Map.Entry<String, List<String>> entry : map.entrySet()){
                    String key = entry.getKey();
                    List<String> values = entry.getValue();
                    if(values.contains(s)){
                        System.out.println(key);
                        break;
                    }
                }
            }
        }
    }
}
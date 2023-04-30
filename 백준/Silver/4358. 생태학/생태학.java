import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        int count=0;
        while (true){
            String s = br.readLine();
            if(s == null || s.length() == 0)
                break;
            count++;
            map.put(s,map.getOrDefault(s,0)+1);
        }
        List<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            list.add(key);
        }
        Collections.sort(list);
        for (String s : list) {
            System.out.print(s + " ");
            double d = (double) map.get(s) / count * 100;
            System.out.printf("%.4f", d);
            System.out.println();
        }
    }
}
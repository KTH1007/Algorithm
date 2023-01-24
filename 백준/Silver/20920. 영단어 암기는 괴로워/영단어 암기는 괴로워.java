import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.length()<m)
                continue;
            Integer count = map.getOrDefault(s, 0);
            map.put(s, count+1);
        }
        List<String> words = map.keySet().stream().collect(Collectors.toList());
        words.sort((o1, o2) -> {
            int c1=map.get(o1);
            int c2=map.get(o2);

            if(c1==c2){
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2); // 사전 순
                }
                return o2.length()-o1.length(); // 단어 길이
            }
            return c2-c1; // 자주 나오는 단어
        });

        for(int i=0; i <words.size(); i++){
            sb.append(words.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
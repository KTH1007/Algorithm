import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        char c = 'A';
        for(int i=1; i<=26; i++){
            String s = Character.toString(c);
            c++;
            map.put(s,i);
        }
        int count = 27;
        for(int i=0; i<msg.length(); i++){
            int a = 1;
            while(i+a <=msg.length() && map.containsKey(msg.substring(i,i+a))){
                a++;
            }
            if(i+a > msg.length()){
                list.add(map.get(msg.substring(i)));
                break;
            }
            list.add(map.get(msg.substring(i,i+a-1)));
            map.put(msg.substring(i,i+a),count++);
            if(a>1)
                i += a-2;
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
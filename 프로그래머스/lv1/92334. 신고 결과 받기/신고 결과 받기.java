import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> idxMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], new HashSet<>());
            idxMap.put(id_list[i], i);
        }
        for(int i=0; i<report.length; i++){
            String[] s = report[i].split(" ");
            map.get(s[1]).add(s[0]);
        }
        for(int i=0; i<id_list.length; i++){
            HashSet<String> send = map.get(id_list[i]);
            if(send.size() >= k){
                for(String name : send){
                    answer[idxMap.get(name)]++;
                }
            }
        }
        return answer;
    }
}
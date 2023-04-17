import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        for(String c : callings){
            int cur = map.get(c);
            map.put(c, cur-1);
            map.put(players[cur-1], cur);
            players[cur] = players[cur - 1];
            players[cur-1] = c;
        }
        return players;
    }
}
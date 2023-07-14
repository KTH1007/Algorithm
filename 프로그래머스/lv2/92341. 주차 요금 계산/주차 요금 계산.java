import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> cost = new HashMap<>();
        List<String> list = new ArrayList<>();
        int minute = 0;
        for(int i=0; i<records.length; i++){
            String[] s = records[i].split(" ");
            String[] time = s[0].split(":");
            minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            if(s[2].equals("IN")){
                if(!list.contains(s[1]))
                    list.add(s[1]);
                map.put(s[1], minute);
            }
            else if(s[2].equals("OUT")){
                int temp = minute-map.get(s[1]);
                cost.put(s[1], cost.getOrDefault(s[1],0) + temp);
                map.remove(s[1]);
                
            }      
        }
        for(int i=0; i<list.size(); i++){
            if(map.containsKey(list.get(i))){
                minute = 23*60+59;
                int temp = minute-map.get(list.get(i));
                cost.put(list.get(i), cost.getOrDefault(list.get(i),0) + temp);
                map.remove(list.get(i));
            }
        }
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            int total = cost.get(list.get(i));
            int price = calculateFee(total, fees);
            answer[i] = price;
            
        }
        return answer;
    }
    static int calculateFee(int total, int[] fees){
        if(total <= fees[0])
            return fees[1];
        else{
            total -= fees[0];
            int time = (int)Math.ceil((double)total/fees[2]);
            return fees[1] + time * fees[3];
        }
    }
}
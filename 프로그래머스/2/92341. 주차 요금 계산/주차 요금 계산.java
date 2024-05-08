import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        List<String> carList = new ArrayList<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            String s = arr[0];
            int time = (Integer.parseInt(s.substring(0,2)) * 60) + Integer.parseInt(s.substring(3,5));
            String num = arr[1];
            
            if (!carList.contains(num)) {
                carList.add(num);
            }
            
            String inOut = arr[2];
            
            if (inOut.equals("IN")) {
                map.put(num, time);
            } else if (inOut.equals("OUT")) {
                result.put(num, result.getOrDefault(num, 0) + time - map.get(num));
                map.remove(num);
            }
        }
        
        int endTime = 23 * 60 + 59;
        for (String key : map.keySet()) {
            result.put(key, result.getOrDefault(key, 0) + endTime - map.get(key));
        }
        
        Collections.sort(carList);
        
        int[] answer = new int[carList.size()];
        
        for (int i = 0; i < carList.size(); i++) {
            if (result.get(carList.get(i)) <= fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = fees[1] + (int) Math.ceil(((double) (result.get(carList.get(i))) - fees[0]) / fees[2]) * fees[3];
            }
        }
        return answer;
    }
}
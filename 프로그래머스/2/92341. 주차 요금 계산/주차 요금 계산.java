import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        ArrayList<String> carList = new ArrayList<>();
        
        for (int i = 0; i < records.length; i++) {
            st =  new StringTokenizer(records[i]);
            
            String temp = st.nextToken();
            int hour = Integer.parseInt(temp.substring(0, 2)) * 60;
            int minute = Integer.parseInt(temp.substring(3, 5));
            int time = hour + minute;
            
            String num = st.nextToken();
            
            String io = st.nextToken();
            
            // result map에는 시간만 넣기
            
            if (io.equals("IN")) {
                if (!carList.contains(num)) {
                    carList.add(num);
                }
                map.put(num, time);
            } else if (io.equals("OUT")) {
                int tempTime = time - map.get(num);
                result.put(num, result.getOrDefault(num, 0) + tempTime);
                map.remove(num);
            }
        }
        
        // 출차 기록이 없는 차량
        for (String key : map.keySet()) {
            int tempTime = 23 * 60 + 59 - map.get(key);
            result.put(key, result.getOrDefault(key, 0) + tempTime);
        }
        
        int[] answer = new int[carList.size()];
        Collections.sort(carList);
        
        for (int i = 0; i < carList.size(); i++) {
            int time = result.get(carList.get(i));
            int totalFee = fee(fees, time);
            answer[i] = totalFee;
        }
        return answer;
    }
    
    public int fee(int[] fees, int time) {
        if (time <= fees[0]) {
            return fees[1];
        } else {
            return (int) (Math.ceil((double)(time - fees[0]) / fees[2])) * fees[3] + fees[1];
        }
    }
}

/*
records 원소를 " " 단위로 분리해서 배열에 담기
차량 입/출차 시간을 분으로 변환 substring(0, 2) * 60 + (3, 5)
입차의 경우 map에 차량번호, 시간

요금 = 출차의 경우 현재 시간 - map.get(차량번호)
if 요금 <= 기본시간   -> 기본요금
else 요금 / 단위 시간 * 단위 요금
출차하면 map.remove(차량번호)
출차 기록이 없는지 확인 방법
map.keySet()으로 반복
*/
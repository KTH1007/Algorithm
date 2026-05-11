import java.util.*;

// 입차 출차 기록 -> 차량별 요금 계산
// 기본 시간 - 기본 요금
// 추가 시간당 추가 요금 ((주차 시간 - 기본 시간) / 단위 시간) * 단위 요금 -> 기본시간 넘은 경우만
// 주차 시간은 숫자로 변환
// 출차 기록이 없으면 23:59 출차
// 차량별 누적 요금
// 차량 번호가 작은 자동차부터 -> List로 정렬
// 출차 체크해야 됨 map 에 보관

// 시간을 다 넣어두고 한 번에 계산


class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 자동차별 누적 시간
        Map<Integer, Integer> carTimes = new HashMap<>();
        // 차량번호, 입차시간
        Map<Integer, Integer> cars = new HashMap<>();
        
        for (String record : records) {
            String[] info = record.split(" ");
            int time = changeTime(info[0]);
            int carNumber = Integer.parseInt(info[1]);
            String type = info[2];
            
            if (type.equals("IN")) {
                cars.put(carNumber, time);
            } else {
                int diffTime = time - cars.get(carNumber);
                
                carTimes.put(carNumber, carTimes.getOrDefault(carNumber, 0) + diffTime);
                cars.remove(carNumber);
            }
            
        }
        
        int lastTime = changeTime("23:59");
        
        // 출차 안 한 차량들 계산
        for (int carNumber : cars.keySet()) {
            int diffTime = lastTime - cars.get(carNumber);
            carTimes.put(carNumber, carTimes.getOrDefault(carNumber, 0) + diffTime); 
        }
        
        // 요금 계산
        List<int[]> feeList = new ArrayList<>();
        for (int car : carTimes.keySet()) {
            int carFee = calcurateFees(carTimes.get(car), fees[0], fees[1], fees[2], fees[3]);
            feeList.add(new int[]{car, carFee});
        }
        
        int[] answer = new int[feeList.size()];
        feeList.sort((o1, o2) -> o1[0] - o2[0]);
        
        for (int i = 0; i < feeList.size(); i++) {
            answer[i] = feeList.get(i)[1];
        }
        
        return answer;
    }
    
    private static int changeTime(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]) * 60;
        int minute = Integer.parseInt(times[1]);
        return hour + minute;
    }
    
    private static int calcurateFees(int time, int baseTime, int baseFee, int partTime, int partFee) {
        if (time <= baseTime) {
            return baseFee;
        }
        
        // 334 - 180 -> 154
        int newTime = time - baseTime;
        
        int newFee = (newTime / partTime) * partFee;
        if (newTime % partTime != 0) {
            newFee += partFee;
        }
        
        return baseFee + newFee;
    }
}
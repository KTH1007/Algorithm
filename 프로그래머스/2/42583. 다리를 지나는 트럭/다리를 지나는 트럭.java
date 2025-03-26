import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int currentWeight = 0;
        
        for (int truck : truck_weights) {
            while (true) {
                
                // 다리에 트럭이 없는 경우
                if (bridge.isEmpty()) {
                    bridge.add(truck);

                    currentWeight += truck;
                    time++;
                    
                    break;
                // 다리에 트럭이 있는 경우
                } else if (bridge.size() != bridge_length) {
                    // 진입 가능
                    if (currentWeight + truck <= weight) {
                        time++;
                        currentWeight += truck;
                        bridge.add(truck);
                        break;
                    // 진입 불가능
                    } else {
                        time++;
                        bridge.add(0);

                    }
                // 다리가 꽉찬 경우
                } else {
                    currentWeight -= bridge.poll();
                    // time++;
                }
            }
        }
        
        answer = time + bridge_length;
        return answer;
    }
}
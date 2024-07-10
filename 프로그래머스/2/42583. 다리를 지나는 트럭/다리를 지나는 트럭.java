import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int currentWeigth = 0;
        int time = 0;
        
        for (int truck : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) {
                    currentWeigth = truck;
                    bridge.add(truck);
                    time++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    currentWeigth -= bridge.poll();
                } else {
                    if (currentWeigth + truck <= weight) {
                        currentWeigth += truck;
                        bridge.add(truck);
                        time++;
                        break;
                    } else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }
        
        answer = time + bridge_length;
        return answer;
    }
}
import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 7;
        int zero = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0)
                zero++;
            map.put(lottos[i], 1);
        }
        for(int i=0; i<win_nums.length; i++){
            if(map.containsKey(win_nums[i]))
                count--;
        }
        if(count == 7)
            count=6;
        if(zero == 0){
            answer[0] = count;
            answer[1] = count;
        }
        else if(zero == 1){
            answer[0] = count-1;
            answer[1] = count;
        }
        else if(zero == 2){
            answer[0] = count-2;
            answer[1] = count;
        }
        else if(zero == 3){
            answer[0] = count-3;
            answer[1] = count;
        }
        else if(zero == 4){
            answer[0] = count-4;
            answer[1] = count;
        }
        else if(zero == 5){
            answer[0] = count-5;
            answer[1] = count;
        }
        else if(zero == 6){
            answer[0] = 1;
            answer[1] = 6;
        }
        return answer;
    }
}
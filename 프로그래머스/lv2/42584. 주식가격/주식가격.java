import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<prices.length; i++){
            int count = 0;
            for(int j=i+1; j<prices.length; j++){
                if(prices[i] <= prices[j])
                    count++;
                else{
                    count++;
                    break;
                }
            }
            list.add(count);
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
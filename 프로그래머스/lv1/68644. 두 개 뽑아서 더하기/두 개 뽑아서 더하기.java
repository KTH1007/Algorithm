import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(i == j)
                    continue;
                int sum = numbers[i] + numbers[j];
                if(list.indexOf(sum) < 0)
                    list.add(sum);
            }
        }
        Collections.sort(list);

        int[] answer = new int[list.size()]; 
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
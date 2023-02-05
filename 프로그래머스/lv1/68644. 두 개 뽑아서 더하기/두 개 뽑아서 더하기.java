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
        List<Integer> anslist = new ArrayList<>();
        anslist.add(list.get(0));
        for(int i=1; i<list.size(); i++){
            if(list.get(i-1) == list.get(i)){
                continue;
            }
            else
                anslist.add(list.get(i));
        }
        int[] answer = new int[anslist.size()]; 
        for(int i=0; i<answer.length; i++){
            answer[i] = anslist.get(i);
        }
        return answer;
    }
}
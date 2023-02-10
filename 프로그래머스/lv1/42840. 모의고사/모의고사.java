import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];
        for(int i=0; i<answers.length; i++){
            if(answers[i] == student1[i%student1.length]){
                count[0]++;
            }
            if(answers[i] == student2[i%student2.length]){
                count[1]++;
            }
            if(answers[i] == student3[i%student3.length]){
                count[2]++;
            }
        }
        int max = Math.max(count[0],Math.max(count[1],count[2]));
        List<Integer> list = new ArrayList<>();
        if(max == count[0])
            list.add(1);
        if(max == count[1])
            list.add(2);
        if(max == count[2])
            list.add(3);
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
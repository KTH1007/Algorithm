import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            list.add(score[i][0] + score[i][1]);
        }
        Collections.sort(list, Collections.reverseOrder());
        int[] answer = new int[score.length];
        //indexOf를 사용하면 제일 작은 값이 나옴
        for(int i=0; i<answer.length; i++){
            answer[i] = list.indexOf(score[i][0] + score[i][1]) + 1;
        }
        return answer;
    }
}
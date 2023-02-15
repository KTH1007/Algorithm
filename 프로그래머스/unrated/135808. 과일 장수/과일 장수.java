import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int size = score.length;
        Arrays.sort(score);
        List<Integer> list = new ArrayList<>();
        while(true){
            if(size < m)
                break;
            list.add(score[size-m]);
            size -= m;
        }
        for(int i=0; i<list.size(); i++){
            answer += list.get(i) * m;
        }
        return answer;
    }
}
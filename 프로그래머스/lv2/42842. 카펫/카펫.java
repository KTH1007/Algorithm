import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int a = 1;
        int min = Integer.MAX_VALUE;
        int sum = brown + yellow;
        for(int i=1; i<=sum/2; i++){
            if(sum%i == 0 && ((i-2)  * (sum/i - 2)) == yellow ){
                answer[0] = i;
                answer[1] = sum/i;
            }
        }
        return answer;
    }
}
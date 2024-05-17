import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int k = 0;
        
        for (int i = people.length - 1; i >= k; i--) {
            if (people[i] + people[k] <= limit) {
                k++;
            }
            answer++;
        }
        return answer;
    }
}
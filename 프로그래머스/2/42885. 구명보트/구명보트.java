import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int count = 0;
        
        for (int i = people.length - 1; i >= count; i--) {
            if (people[i] + people[count] <= limit) {
                count++;
            }
            answer++;
        }
        return answer;
    }
}
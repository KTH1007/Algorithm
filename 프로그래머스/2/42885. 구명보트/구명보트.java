import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        // 투포인터?
    
        return twoPointer(people, limit);
    }
    
    private int twoPointer(int[] people, int limit) {
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                count++;
                left++;
                right--;
            } else {
                count++;
                right--;
            }
        }
        
        return count;
    }
}
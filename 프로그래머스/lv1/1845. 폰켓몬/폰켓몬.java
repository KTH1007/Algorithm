import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int cnt = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
        	if(set.size() == nums.length/2) {
        		break;
        	}
        	if(set.contains(nums[i])){
        		continue;
        	}
        	else {
        		set.add(nums[i]);
        		cnt++;
        	}
        }
        answer = cnt;
        return answer;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static int answer = 0;
    public int solution(int[] nums) {
        // int answer = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        boolean[] prime = new boolean[sum + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        isPrime(prime, sum);

        dfs(0, nums, new ArrayList<>(), prime);
        return answer;
    }

    private void dfs(int depth, int[] nums, List<Integer> selected, boolean[] prime) {
        if (selected.size() == 3) {
            int sum = 0;
            for (Integer i : selected) {
                sum += i;
            }
            if (prime[sum]) answer++;
            return;
        }
        
        if (depth == nums.length) return;
        
        // 현재 요소 선택
        selected.add(nums[depth]);
        dfs(depth + 1, nums, selected, prime);
        // 현재 요소 선택X
        selected.remove(selected.size() - 1);
        dfs(depth + 1, nums, selected, prime);
    }

    private void isPrime(boolean[] prime, int sum) {
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= sum; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return answer;
    }
    static void DFS(int[] numbers, int target, int depth, int sum){
        if(depth == numbers.length){
            if(sum == target) answer++;
        }
        else{
            DFS(numbers, target, depth+1, sum + numbers[depth]);
            DFS(numbers, target, depth+1, sum - numbers[depth]);
        }
        
    }
}

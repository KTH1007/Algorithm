import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int diff = 0;
        
        Arrays.sort(arr);
        answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = answer * arr[i] / gcd(answer, arr[i]);
        }
        return answer;
    }
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
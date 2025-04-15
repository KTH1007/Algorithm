class Solution {
    public int solution(int[] arr) {
        if (arr.length == 1) return arr[0];
        
        int gcd = getGcd(arr[0], arr[1]);
        int answer = arr[0] * arr[1] / gcd;
        
        for (int i = 1; i < arr.length; i++) {
            answer = answer * arr[i] / getGcd(answer, arr[i]);
        }
        
        return answer;
    }
    
    public int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}
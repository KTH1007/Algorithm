class Solution {
    public int solution(int[] arr) {
        int answer = arr[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            answer = (answer * arr[i]) / gcd(answer, arr[i]);
        }
        return answer;
    }
    
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
        }
}


class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        int a = M-1;
        int b = M * (N-1);
        answer = a + b;
        return answer;
    }
}
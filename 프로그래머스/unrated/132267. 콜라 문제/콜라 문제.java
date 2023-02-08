class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        if(n < a) return answer;
        int receive = 0;
        while(n>=a){
            receive = (n/a)*b;
            answer += receive;
            n = n%a + receive;
        }
        return answer;
    }
}
class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];
        int a = denum1*num2 + denum2*num1;
        int b = num1*num2;
        int min = (a < b) ? a : b;
        int gcd = 0;
        for(int i=1; i<= min; i++){
            if(a%i == 0 && b%i == 0){
                gcd = i;
            }
        }
        a /= gcd;
        b /= gcd;
        answer[0] = a;
        answer[1] = b;
        return answer;
    }
}
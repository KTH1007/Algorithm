import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        // 1 2 -> 1     3 4 -> 4(2로 변환)   5 6 ->5(3)  7 8 -> 7(4)
        // 1 4(2) -> 4(2->1)     5(3) 7(4) -> 7(4->2)
        // 4(1) 7(2)
        while(a!=b){
            a = a/2 + a%2;
            b = b/2 + b%2;
            answer++;
        }
        return answer;
    }
}
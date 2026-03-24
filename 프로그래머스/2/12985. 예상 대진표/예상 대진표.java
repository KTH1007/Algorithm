import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // a 3 b = 8
        // 1 2 3 4 5 6 7 8
        // 1 3 5 8
        // 3 8
        
        // n이 계속 절반씩 낮아짐
        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
        }
        return answer;
    }
}
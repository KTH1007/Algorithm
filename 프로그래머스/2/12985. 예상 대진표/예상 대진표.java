class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        while (true) {
            if (Math.abs(a - b) == 1 && (a % 2 == 1 && b % 2 == 0))  break;
            
            if (a % 2 == 0) a /= 2;
            else a = a / 2 + 1;
            
            if (b % 2 == 0) b /= 2;
            else b = b / 2 + 1;
            
            answer++;
        }
        return answer;
    }
}

/* 
1 2   3  4    5  6   7  8
1  2   3  4
1 2
*/
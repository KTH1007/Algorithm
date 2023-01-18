import java.util.*;
import java.io.*;
class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        //분자와 분모의 최대공약수를 구한 후 분모를 최대 공약수로 나눠준다.
        int newB = b / gcd(a, b);
        answer = 1;
        while(newB != 1){
            if(newB % 2 == 0)
                newB /= 2;
            else if(newB % 5 == 0)
                newB /= 5;
            else{
                answer = 2;
                break;
            }
                
            
        }
        
        return answer;
    }
    public int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}

/*
유클리드 호제법
1071은 1029로 나누어 떨어지지 않기 때문에, 1071을 1029로 나눈 나머지를 구한다. ≫ 42
1029는 42로 나누어 떨어지지 않기 때문에, 1029를 42로 나눈 나머지를 구한다. ≫ 21
42는 21로 나누어 떨어진다.
최대공약수는 21이다.
*/
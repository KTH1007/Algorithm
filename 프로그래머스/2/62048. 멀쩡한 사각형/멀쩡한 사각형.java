import java.util.*;
class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h;
        
        // 원래 정사각형 - 잘린 정사각형
        // 최대 공약수 4
        int gcd = gcd(w, h);
        // w / 최대공약수, h / 최대공약수 크기의 직사각형이 최대공약수만큼 반복
        answer = (long) w * h -  ((long) w / gcd * h / gcd) * gcd;
        
        // 잘리지 않은 직사각형을 더해줘야 됨
        // 2 * 3 직사각형 기준 2개가 나옴 (w / gcd - 1) * (h / gcd - 1)
        answer += ((long) w / gcd - 1) * ((long) h / gcd - 1) * gcd;
        return answer;
    }
    
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
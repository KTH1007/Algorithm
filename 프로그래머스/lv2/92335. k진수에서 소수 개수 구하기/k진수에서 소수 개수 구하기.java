import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String binary = Integer.toString(n, k);
        String[] s = binary.split("0");
        long num = 0;
        for(int i=0; i<s.length; i++){
            if(!s[i].equals(""))
                num = Long.parseLong(s[i]);
            else continue;
            if(isPrime(num) == 1)
                answer++;
        }
        return answer;
    }
    static int isPrime(long n){
        if(n == 1) return 0;
        long l = (long)Math.sqrt(n) + 1;
        for(int i=2; i<l; i++){
            if(n % i == 0)
                return 0;
        }
        return 1;
    }
}
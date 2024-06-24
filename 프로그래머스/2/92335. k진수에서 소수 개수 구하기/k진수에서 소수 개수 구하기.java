import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        
        String[] arr = s.split("0");
        for (String a : arr) {
            if (!a.equals("")) {
                if (isPrime(Long.parseLong(a))) {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        System.out.println(s);
        
        
        String[] arr = s.replace("0", " ").split("\\s+");
        
        for (int i = 0; i < arr.length; i++) {
            long temp = Long.parseLong(arr[i]);
            if (isPrime(temp)) answer++;
            System.out.println(arr[i]);
        }
        return answer;
    }
    boolean isPrime(long n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
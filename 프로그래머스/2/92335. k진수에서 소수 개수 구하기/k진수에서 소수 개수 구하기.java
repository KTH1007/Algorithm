import java.util.*;

// n -> k 진수로 변경
// 소수의 개수 판별
// 0P0, P0, 0P, P
// 0으로 나누기 211020101011 -> 211 2 1 1 11 x / 211 2 11 O


class Solution {
    static boolean[] prime;
    
    public int solution(int n, int k) {
        int answer = 0;
        // prime = new boolean[1000001];
        String s = Integer.toString(n, k);
        
        // Arrays.fill(prime, true);
        // prime[0] = false;
        // prime[1] = false;
        // isPrime(1000000);
        
        // 0으로 split 후 소수 판별
        String[] arr = s.split("0");
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) {
                continue;
            }
            
            long num = Long.parseLong(arr[i]);
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // 에라토스테네스의 체
    // private static void isPrime(int num) {
    //     for (int i = 2; i <= Math.sqrt(num); i++) {
    //         if (prime[i]) {
    //             for (int j = i * i; j <= num; j += i) {
    //                 prime[j] = false;
    //             }
    //         }
    //     }
    // }
}
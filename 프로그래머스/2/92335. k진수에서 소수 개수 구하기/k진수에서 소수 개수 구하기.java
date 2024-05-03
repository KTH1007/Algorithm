class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        // System.out.println(s);
        String[] arr = s.split("0");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) continue;
            long temp = Long.parseLong(arr[i]);
            // System.out.println(temp);
            
            if (isPrime(temp)) answer++;
        }
        return answer;
    }
    boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
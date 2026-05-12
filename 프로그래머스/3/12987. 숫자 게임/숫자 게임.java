import java.util.*;

class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        answer = twoPointer(A, B);
        return answer;
    }
    
    private static int twoPointer(int[] A, int[] B) {
        int result = 0;
        int i = 0;
        int j = 0;
        
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                result++;
                // System.out.println(B[j]);
                i++;
                j++;
            } else {
                j++;
            }
        }
        
        return result;
    }
    
}
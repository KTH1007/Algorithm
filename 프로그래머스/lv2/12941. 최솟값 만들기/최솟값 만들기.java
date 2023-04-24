import java.util.*;
class Solution{
    public int solution(int []A, int []B){
        int answer = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(A);
        Integer[] b = new Integer[A.length];
        for(int i=0; i<b.length; i++){
            b[i] = B[i];
        }
        Arrays.sort(b, Collections.reverseOrder());
        for(int i=0; i<A.length; i++){
            answer += A[i]*b[i];
        }
        return answer;
    }
}
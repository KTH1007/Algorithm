import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int[] x = new int[dots.length];
        int[] y = new int[dots.length];
        for(int i=0; i<dots.length; i++){
            x[i] = dots[i][0];
            y[i] = dots[i][1];
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int ax = Math.abs(x[0] - x[dots.length-1]);
        int ay = Math.abs(y[0] - y[dots.length-1]);
        answer = ax * ay;
        return answer;
    }
}
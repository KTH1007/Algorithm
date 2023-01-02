class Solution {
    public double slope(int[] dot1, int[] dot2){
        return (double)(dot2[1]-dot1[1])/(dot2[0]-dot1[0]);
    }
    public int solution(int[][] dots) {
        int answer = 0;
        if(slope(dots[0],dots[1]) == slope(dots[2],dots[3]))
            answer++;
        else if(slope(dots[0],dots[2]) == slope(dots[1],dots[3]))
            answer++;
        else if(slope(dots[0],dots[3]) == slope(dots[1],dots[2]))
            answer++;
        return answer;
    }
}

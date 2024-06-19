class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        
        int count = 0;
        for (long i = left; i <= right; i++) {
            int row = (int) (i % n);
            int col = (int) (i / n);
            answer[count++] = Math.max(row, col) + 1;
        }
        return answer;
    }
}
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for (int i = 3; i < sum; i++) {
            if (sum % i == 0) {
                int w = i;
                int h = sum / i;
                
                if ((h - 2) * (w - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                }
            }
        }
        return answer;
    }
}
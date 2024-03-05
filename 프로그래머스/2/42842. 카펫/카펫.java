class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        // sum 약수 구하기
        // 단 세로 길이가 3이상이어야 노란색 카펫을 감쌀 수 있음
        for (int i = 3; i < sum; i++) {
            int width = sum / i;
            
            if (width >= i) {
                if ((i - 2) * (width - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = i;
                    break;
                }
            }
        }
        return answer;
    }
}
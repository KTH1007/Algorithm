class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        // sum 약수 구하기
        // 세로 길이는 노란색을 감쌀 수 있게 최소 3이상
        
        for (int i = 3; i < sum; i++) {
            int width = sum / i;
            
            if (width >= i) {
                if ((width - 2) * (i - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = i;
                    break;
                }
            }
        }
        return answer;
    }
}
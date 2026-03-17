class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        // 가로 * 세로 == brwon + yellow
        
        // 가로 * 2 + 세로 * 2 - 4 => brown
        
        // yellow = 가로 * 세로 - brwon
        
        for (int col = 1; col <= brown + yellow; col++) {
            for (int row = 1; row <= brown; row++) {
                if (row * col == brown + yellow) {
                    int a = row * 2 + col * 2 - 4;
                    int b = row * col - a;
                    if (a == brown && b == yellow) {
                        return new int[]{row, col};
                    }
                }
            }
        }

        return answer;
    }
}
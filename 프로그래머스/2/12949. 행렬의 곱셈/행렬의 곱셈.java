class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr1[1].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}
// 0 0 * 0 0 + 0 1 * 1 0 + 0 2 * 2 0
/*
2 3 2
4 2 4
3 1 4

5 4 ;
2 4 1
3 1 1

10 6 6, 8 12 2, 6 3 2
20 4 12, 16 8 4, 12 2 4
15 6 9
*/
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}

/*
A
[1, 4]
[3, 2]
[4, 1]

B
[3, 3]
[3, 3]

1*3 + 4*3  1*3 + 4*3
3*3 + 2*3  3*3 + 2*3
4*3 + 1*3  4*3 + 1*3

A
[2, 3, 2]
[4, 2, 4]
[3, 1, 4]

B
[5, 4, 3]
[2, 4, 1]
[3, 1, 1]

2*5 + 3*2 + 2*3
4*5 + 2*2 + 4*3
3*5 + 1*2 + 4*3

r[0][0] = (a[0][0] * b[0][0]) + (a[0][1] * b[1][0]) + (a[0][2] * b[2][0])
*/
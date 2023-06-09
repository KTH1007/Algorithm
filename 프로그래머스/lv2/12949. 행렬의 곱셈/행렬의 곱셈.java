class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Row = arr1.length;
        int arr1Col = arr1[0].length;
        int arr2Row = arr2.length;
        int arr2Col = arr2[0].length;
        int[][] answer = new int[arr1Row][arr2Col];
        for(int row=0; row<arr1Row; row++){
            for(int col=0; col<arr2Col; col++){
                int sum = 0;
                for(int i=0; i<arr1Col; i++){
                    sum += arr1[row][i] * arr2[i][col];
                }
                answer[row][col] = sum;
            }
            
        }
        
        return answer;
    }
}
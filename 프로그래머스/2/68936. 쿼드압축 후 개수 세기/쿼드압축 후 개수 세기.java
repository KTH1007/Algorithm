import java.util.*;


class Solution {
    static int zero = 0;
    static int one = 0;
    public int[] solution(int[][] arr) {
        
        int size = arr.length;
        back(0, 0, size, arr);
        int[] answer = new int[]{zero, one};
        return answer;
    }
    
    private static void back (int r, int c, int size, int[][] arr) {
        // 카운트세야 함
        if (isSame(r, c, size, arr)) {
            if (arr[r][c] == 0) {
                zero++;
            } else {
                one++;
            }
            
            return;
        }
        
        back(r, c, size / 2, arr);
        back(r + size / 2, c + size / 2, size / 2, arr);
        back(r + size / 2 , c, size / 2, arr);
        back(r,  c + size / 2, size / 2, arr);
    }
    
    private static boolean isSame (int r, int c, int size, int[][] arr) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != arr[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
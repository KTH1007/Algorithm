import java.util.*;

// 같은 블록 2*2형태로 있을 떄 겹쳐있어도 다 삭제
// 블록 제거 후 아래로 내리기

// 블록 제거 로직
// 현재 위치에서 2*2를 찾아야 됨


// 블록 내리기 (row 값 증가)
// bottom (m-1)부터 공백이 아닌 값 채우고 나머지 공백


class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] blocks = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j] = board[i].charAt(j);
            }
        }
        
        while (true) {
            int count = removeBlocks(blocks, m, n);
            if (count == 0) {
                break;
            }
            
            answer += count;
            blockDown(blocks, m, n);
        }
        return answer;
    }
    
    private static int removeBlocks(char[][] blocks, int m, int n) {
        boolean[][] toRemove = new boolean[m][n];
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = blocks[i][j];
                if (c != ' ' &&
                  c == blocks[i + 1][j] &&
                  c == blocks[i][j + 1] &&
                  c == blocks[i + 1][j + 1]) {
                    toRemove[i][j] = true;
                    toRemove[i + 1][j] = true;
                    toRemove[i][j + 1] = true;
                    toRemove[i + 1][j + 1] = true;
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (toRemove[i][j]) {
                    blocks[i][j] = ' ';
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private static void blockDown(char[][] blocks, int m, int n) {
        for (int j = 0; j < n; j++) {
            int bottom = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (blocks[i][j] != ' ') {
                    blocks[bottom--][j] = blocks[i][j];
                }
            }
            
            while (bottom >= 0) {
                blocks[bottom--][j] = ' ';
            }
        }       
    }
}
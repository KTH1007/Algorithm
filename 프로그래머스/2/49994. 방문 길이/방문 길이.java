import java.util.*;

// 상하좌우 UDRL
// 가야되는 길이 벽이면 해당 명령 무시
// 처음걸어본길만 카운트 visited 체크 방문 안 했으면 answer 증가
// 10, 10

class Solution {
    
    private static int[] dr = {1, -1, 0 ,0};
    private static int[] dc = {0, 0, -1, 0};
    private static int[][] map;
    private static boolean[][][][] visited; // 현재위치, 방문위치
    private static int size = 11;
    private static int count = 0;
    
    public int solution(String dirs) {
        int answer = 0;
        
        map = new int[size][size];
        visited = new boolean[size][size][size][size];
        
        getCount(dirs);
        answer = count;
        return answer;
    }
    
    private static void getCount(String dirs) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{5, 5});
        
        int[] current = queue.poll();
        int currentR = current[0];
        int currentC = current[1];
        
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            if (c == 'U' && validatePosition(currentR - 1, currentC)) {
                if (!visited[currentR][currentC][currentR - 1][currentC]) {
                    count++;
                    visited[currentR][currentC][currentR - 1][currentC] = true;
                    visited[currentR - 1][currentC][currentR][currentC] = true;
                }                
                currentR--;
            } else if (c == 'D' && validatePosition(currentR + 1, currentC)) {
                if (!visited[currentR][currentC][currentR + 1][currentC]) {
                    count++;
                    visited[currentR][currentC][currentR + 1][currentC] = true;
                    visited[currentR + 1][currentC][currentR][currentC] = true;
                }
                currentR++;
            } else if (c == 'R' && validatePosition(currentR, currentC + 1)) {
                if (!visited[currentR][currentC][currentR][currentC + 1]) {
                    count++;
                    visited[currentR][currentC][currentR][currentC + 1] = true;
                    visited[currentR][currentC + 1][currentR][currentC] = true;
                }
                currentC++;
            } else if (c == 'L' && validatePosition(currentR, currentC - 1)) {
                if (!visited[currentR][currentC][currentR][currentC - 1]) {
                    count++;
                    visited[currentR][currentC][currentR][currentC - 1] = true;
                    visited[currentR][currentC - 1][currentR][currentC] = true;
                }
                currentC--;
            }
        }
    }
    
    private static boolean validatePosition(int r, int c) {
        if (r >= size || r < 0 || c >= size || c < 0) {            
            return false;
        }
        return true;
    }
}
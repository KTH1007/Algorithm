import java.util.*;

class Solution {
    static class Position {
        private int currentR;
        private int currentC;
        private int count;
        
        public Position(int currentR, int currentC, int count) {
            this.currentR = currentR;
            this.currentC = currentC;
            this.count = count;
        }
        
        public int getCurrentR() {
            return currentR;
        }
        
        public int getCurrentC() {
            return currentC;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int r, c;
    
    public int solution(int[][] maps) {
        int answer = 0;
        r = maps.length;
        c = maps[0].length;
        
        answer = bfs(maps);
        return answer;
    }
    
    private static int bfs(int[][] maps) {
        visited = new boolean[r][c];
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = current.getCurrentR() + dr[i];
                int nc = current.getCurrentC() + dc[i];
                int count = current.getCount();
                
                if (nr < 0 || nr >= r || nc < 0 || nc >= c || visited[nr][nc] || maps[nr][nc] == 0) {
                    continue;
                }
                
                if (nr == r - 1 && nc == c - 1) {
                    return count + 1;
                }
                
                visited[nr][nc] = true;
                queue.add(new Position(nr, nc, count + 1));
            }
        }
        
        return -1;
    }
}
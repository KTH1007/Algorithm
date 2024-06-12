class Solution {
    
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visited = new boolean[11][11][11][11];
        int x = 5;
        int y = 5;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int index = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            if (c == 'U') {
                index = 0;
            } else if (c == 'D') {
                index = 1;
            } else if (c == 'L'){
               index = 2;
            } else {
                index = 3;
            }
            
            int nx = x + dx[index];
            int ny = y + dy[index];
            
            if (nx >= 0 && nx < 11 && ny >= 0 && ny < 11) {
                if (!visited[x][y][nx][ny] && !visited[nx][ny][x][y]) {
                    answer++;
                    visited[x][y][nx][ny] = true;
                    visited[nx][ny][x][y] = true;
                }
                x = nx;
                y = ny;
            }
            
        }
        return answer;
    }
}
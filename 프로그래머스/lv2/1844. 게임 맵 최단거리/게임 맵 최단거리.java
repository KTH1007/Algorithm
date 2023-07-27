import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >=0 && nx< n && ny>= 0 && ny<m && !visited[nx][ny] &&
                  maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,current[2]+1});
                    if(nx == n-1 && ny == m-1)
                        answer = Math.min(answer, current[2]+1);
                }
            }
        }
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        return answer;
    }
}
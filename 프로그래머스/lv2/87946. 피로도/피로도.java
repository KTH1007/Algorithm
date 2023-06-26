import java.util.*;
class Solution {
    static boolean visited[];
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        DFS(0, k, dungeons);
        return answer;
    }
    static void DFS(int depth, int fatigue, int[][] dungeons){
        for(int i=0; i<dungeons.length; i++){
            if(visited[i] || fatigue < dungeons[i][0])
                continue;
            visited[i] = true;
            DFS(depth+1, fatigue - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        answer = Math.max(answer, depth);
        
    }
}
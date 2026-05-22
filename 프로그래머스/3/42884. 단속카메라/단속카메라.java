import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        // 카메라는 end쪽에 두기
        
        answer++;
        int camera = routes[0][1];
        
        for (int i = 1; i < routes.length; i++) {
            int start = routes[i][0];
            int end = routes[i][1];
            
            if (start > camera) {
                answer++;
                camera = end;
            }
        }
      
        return answer;
    }
}
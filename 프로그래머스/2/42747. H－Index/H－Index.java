import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        // 10 11 -> 2
        // 카운트를 증가
        // 카운트보다 큰 배열 크기 확인
        // 카운트가 배열 크기보다 커지면 끝
        
        int count = 0;
        while (count <= citations.length - 1) {
            count++;
            if (numCheck(count, citations)) {
                answer = count;
            }
        }
        return answer;
    }
    
    private static boolean numCheck(int count, int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            if (count <= citations[i]) {
                int length = citations.length - i;
                if (count == length) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
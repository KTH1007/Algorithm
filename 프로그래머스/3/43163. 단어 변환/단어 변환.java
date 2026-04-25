import java.util.*;

// begin -> target 단어 변환 문제 count를 세서 리턴
// 단어의 길이는 같음
// words에 있는 단어중에서 하나를 골라서 변경 가능

class Solution {
    static int result = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        changeWord(0, begin, target, words, 0, visited);
        answer = result;
        
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        return answer;
    }
    
    private static void changeWord(int depth, String begin, String target, String[] words, int count, boolean[] visited) {
        
        if (depth == words.length) {
            return;
        }
        
        if (begin.equals(target)) {
            result = Math.min(result, count);
            return;
        }
        
        // System.out.println(begin);
        
        // 한 개의 알파벳만 변경하는지 확인
        for (int i = 0; i < words.length; i++) {
            if (validateWord(begin, words[i]) && !visited[i]) {
                visited[i] = true;
                changeWord(depth + 1, words[i], target, words, count + 1, visited);
                visited[i] = false;
            }
        }
    }
    
    private static boolean validateWord(String begin, String word) {
        int count = 0;
        
        for (int i = 0; i < word.length(); i++) {
            char c1 = begin.charAt(i);
            char c2 = word.charAt(i);
            
            if (c1 != c2) {
                count++;
            }
        }
        
        if (count > 1) {
            return false;
        }
        
        return true;
    }
}
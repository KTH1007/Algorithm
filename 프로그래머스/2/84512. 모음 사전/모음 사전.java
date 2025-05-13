import java.util.*;

class Solution {
    // 문자열을 담을 결과 리스트
    static List<String> result = new ArrayList<>();
    public int solution(String word) {
        // 모음 배열 생성
        String[] alphabet = {"A", "E", "I", "O", "U"};
        
        dfs(0, new ArrayList<>(), alphabet);
        
        int answer = result.indexOf(word);
        return answer;
    }
    
    private static void dfs(int depth, List<String> selected, String[] alphabet) {
        // 결과 리스트에 삽입
        result.add(selected.toString().replaceAll("[^A-Z]", ""));
        
        if (depth == 5) {
            return;
        }
        
        // 재귀호출
        for (String alpha : alphabet) {
            selected.add(alpha);
            dfs(depth + 1, selected, alphabet);
            selected.remove(selected.size() - 1);
        }
        
    }
}
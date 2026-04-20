import java.util.*;

class Solution {
    
    static List<String> result = new ArrayList<>();
    static String[] arr = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        
        // a, aa, aaa, aaaa, aaaaa, aaaae, aaaai, aaaao, aaaau
        // aaae aaai aaao aaau
        // aaaea aaaee aaaei aaaeo aaaeu
        
        dfs(0, "");
        answer = result.indexOf(word);
        return answer;
    }
    
    private static void dfs(int depth, String str) {
        result.add(str);
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(depth + 1, str + arr[i]);
        }
    }
}
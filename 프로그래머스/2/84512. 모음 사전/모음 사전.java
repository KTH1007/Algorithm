import java.util.*;

class Solution {
    static String[] arr = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        dfs(0, "");
        answer = list.indexOf(word);
        return answer;
    }
    
    private static void dfs(int depth, String current) {
        list.add(current);
        if (depth == 5) return;
        for (int i = 0; i < 5; i++) {
            System.out.println(current + arr[i] + " : " + depth);
            dfs(depth + 1, current + arr[i]);
        }
    }
}

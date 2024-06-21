import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        sub(str1, str1List);
        sub(str2, str2List);
        
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        
        for (String s : str1List) {
            union.add(s);
        }
                
        for (String s : str2List) {
            if (str1List.remove(s)) {
                intersection.add(s);
            } else {
                union.add(s);
            }
        }
        
        if (union.size() == 0 && intersection.size() == 0) return 65536;
        answer = (int) (((double) intersection.size() / (double) union.size()) * 65536);
        
        
        return answer;
    }
    static void sub(String str, List<String> list) {
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                list.add(str.substring(i, i + 2));
            }
        }
    }
}
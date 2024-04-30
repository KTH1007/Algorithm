import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        listAdd(str1, list1);
        listAdd(str2, list2);
        
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        for (String s : list1) {
            if (list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        for (String s : list2) {
            union.add(s);
        }
        
        if (intersection.size() == 0 && union.size() == 0) return 65536;
        answer = (int) ((double) intersection.size() / (double) union.size() * 65536);

        return answer;
    }
    
    public void listAdd(String str, List<String> list) {
        String s;
        for (int i = 0; i < str.length() - 1; i++) {
            s = str.substring(i, i + 2);
            if ((s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') &&
               (s.charAt(1) >= 'A' && s.charAt(1) <= 'Z')) {
                list.add(s);
            }
        }
    }
}